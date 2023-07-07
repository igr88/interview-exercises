package dev.me.exercises.patterns;

/*
consider an application that processes different types of documents, such as PDF, Word, and Excel.
Each document type has its own implementation with specific functionalities. The client code needs
to create instances of these documents based on user input or other criteria.
 */

import dev.me.exercises.patterns.DocumentType.Type;

interface DocumentType {
    enum Type {
        WORD,
        PDF
    }

    String getName();
    Type getType();
}

class WordDocument implements DocumentType {
    private final String name;
    private final Type type;
    public WordDocument(String name) {
        this.name = name;
        this.type = Type.WORD;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return type;
    }
}

class PdfDocument implements DocumentType {
    private final String name;
    private final Type type;

    PdfDocument(String name) {
        this.name = name;
        this.type = Type.PDF;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}

class DocumentFactory {
    public DocumentType getDocument(Type type, String documentName) {
        return switch (type) {
            case WORD -> new WordDocument(documentName);
            case PDF -> new PdfDocument(documentName);
        };
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        DocumentFactory factory = new DocumentFactory();
        DocumentType pdf = factory.getDocument(Type.PDF, "test.pdf");
        DocumentType word = factory.getDocument(Type.WORD, "test.doc");

        System.out.println(String.format("Is %s instance of PdfDocument? %s", pdf.getType(), (pdf instanceof PdfDocument)));
        System.out.println(String.format("Is %s instance of WordDocument? %s", word.getType(), (word instanceof WordDocument)));
    }
}
