🚀 SmartDocs AI

SmartDocs AI is a Retrieval-Augmented Generation (RAG) system that lets users upload PDF documents and ask questions using natural language.
It retrieves relevant content using vector similarity and generates accurate answers using an LLM.

🧠 Features
📄 Upload and process PDF documents
✂️ Automatic text chunking
🔍 Semantic search using embeddings
🤖 AI-powered question answering
⚡ Fast backend using Spring Boot


🏗️ Architecture
PDF → Text Extraction → Chunking → Embeddings → Vector Store
                                                ↑
User Question → Embedding → Similarity Search → LLM → Answer


🛠️ Tech Stack
Backend: Spring Boot
AI Framework: Spring AI
LLM: Google Gemma 3 (27B) via OpenRouter
Vector Store: SimpleVectorStore (in-memory)
Document Processing: PagePdfDocumentReader + TokenTextSplitter


📂 Project Structure
src/
 ├── main/
 │   ├── java/com/dailycodebuffer/
 │   │   ├── config/
 │   │   ├── controller/
 │   │   ├── service/
 │   │   │   └── strategy/
 │   └── resources/
 │       └── application.properties

 
⚙️ Setup Instructions

1. Clone the Repository
git clone https://github.com/rajgiiit/SmartDocs-AI.git
cd SmartDocs-AI
2. Configure API Key (IMPORTANT)

Do NOT hardcode your API key.

Update application.properties:

spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.base-url=https://openrouter.ai/api
spring.ai.openai.chat.options.model=google/gemma-3-27b-it:free

Set environment variable:

Windows

setx OPENAI_API_KEY "your_api_key"

Linux/Mac

export OPENAI_API_KEY=your_api_key
3. Run the Application
mvn spring-boot:run
📡 API Endpoints
📄 Upload PDF
POST /api/documents/upload
💬 Ask Question
GET /api/chat/ask?question=your_question
🧪 Example Workflow
Upload a PDF
Ask a question like:
What is the main topic of this document?
Get an AI-generated answer based on document context

🚧 Limitations

Uses in-memory vector store (data is lost on restart)
Free LLM models may have latency or rate limits
🔮 Future Improvements
PostgreSQL + PGVector integration
Support for DOCX, TXT files
Frontend UI
Authentication system
Streaming responses

👨‍💻 Author
Ritik Raj
