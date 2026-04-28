🚀 SmartDocs AI

SmartDocs AI is a Retrieval-Augmented Generation (RAG) system that allows users to upload PDF documents and ask questions from them using natural language. It combines vector search with LLMs to deliver accurate, context-aware answers.

🧠 Features
📄 Upload and process PDF documents
✂️ Automatic text chunking and embedding
🔍 Semantic search using vector similarity
🤖 AI-powered question answering
⚡ Fast and scalable backend using Spring Boot
🏗️ Architecture
PDF → Text Extraction → Chunking → Embeddings → Vector Store
                                                ↑
User Question → Embedding → Similarity Search → LLM → Answer
🛠️ Tech Stack
Backend: Spring Boot
AI Framework: Spring AI
LLM: Google Gemma 3 (27B) via OpenRouter
Vector Store: SimpleVectorStore (in-memory)
Document Processing: PDF Reader + TokenTextSplitter
📂 Project Structure
src/
 ├── main/
 │   ├── java/com/dailycodebuffer/
 │   │   ├── config/         # AI configuration
 │   │   ├── controller/     # REST APIs
 │   │   ├── service/        # Business logic
 │   │   │   └── strategy/   # Document reader strategy
 │   └── resources/
 │       └── application.properties
⚙️ Setup Instructions
1. Clone the repository
git clone https://github.com/rajgiiit/SmartDocs-AI.git
cd SmartDocs-AI
2. Configure environment variables

⚠️ Do NOT hardcode API keys.

export OPENAI_API_KEY=your_api_key

Update application.properties:

spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.base-url=https://openrouter.ai/api
spring.ai.openai.chat.options.model=google/gemma-3-27b-it:free
3. Run the application
mvn spring-boot:run
📡 API Endpoints
📄 Upload PDF
POST /api/documents/upload
💬 Ask Question
GET /api/chat/ask?question=Your question here
🧪 Example
Upload a PDF

Ask:

What is the main topic of the document?
Get AI-generated answer based on document context
🚧 Limitations
Uses in-memory vector store (data lost on restart)
Free LLM models may have latency or rate limits
🔮 Future Improvements
🔗 Integrate PostgreSQL + PGVector
📁 Support multiple file formats (DOCX, TXT)
🌐 Add frontend UI
🔐 Authentication & user management
⚡ Streaming responses
👨‍💻 Author
Ritik Raj
