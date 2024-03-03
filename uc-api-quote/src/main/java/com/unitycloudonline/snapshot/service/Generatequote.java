package com.unitycloudonline.snapshot.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Generatequote {

    private List<String> quotes;

    public Generatequote() {
        quotes = new ArrayList<>();
        loadQuotesFromXml();
    }

    private void loadQuotesFromXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream is = new ClassPathResource("quotes.xml").getInputStream();
            Document doc = builder.parse(is);
            NodeList nodeList = doc.getElementsByTagName("quote");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    quotes.add(element.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String newQuote() {
        if (!quotes.isEmpty()) {
            int index = new Random().nextInt(quotes.size());
            return quotes.get(index);
        } else {
            return "No quotes available";
        }
    }
}
