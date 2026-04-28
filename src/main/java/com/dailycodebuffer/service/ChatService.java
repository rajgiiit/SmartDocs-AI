package com.dailycodebuffer.service;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final SimpleVectorStore vectorStore;

    public ChatService(ChatModel chatModel, SimpleVectorStore vectorStore) {
        this.vectorStore = vectorStore;
        this.chatClient = ChatClient.builder(chatModel)
                .defaultAdvisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .build();
    }

    public String ask(String question) {
        List<Document> foundDocs = vectorStore.similaritySearch(question);
        System.out.println("====== X-RAY SEARCH ======");
        System.out.println("The database found " + foundDocs.size() + " matching chunks for your question.");
        if (!foundDocs.isEmpty()) {
            System.out.println("TOP MATCH TEXT: " + foundDocs.get(0).getFormattedContent());
        }
        System.out.println("==========================");

        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}