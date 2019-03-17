package org.fir3.avm.environment.resource.io;

import lombok.Getter;
import org.fir3.avm.environment.resource.ResourceType;
import org.fir3.avm.environment.resource.XmlTreeAttribute;
import org.fir3.avm.environment.resource.XmlTreeNode;
import org.fir3.avm.environment.util.CollectionUtil;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentGenerator {
    private static class Util {
        private static DocumentBuilder documentBuilder;

        static DocumentBuilder getDocumentBuilder() {
            if (Util.documentBuilder == null) {
                try {
                    Util.documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                    throw new IllegalStateException(e);
                }
            }

            return Util.documentBuilder;
        }
    }

    @Getter
    private final Document document;
    private Node nodePtr;

    public DocumentGenerator() {
        this.document = Util.getDocumentBuilder().newDocument();
        this.nodePtr = this.document;
    }

    public void proceed(XmlTreeNode node) {
        ResourceType type = CollectionUtil.getFirst(node.getResourceTypes());

        switch (type) {
            case XmlFirstChunk:
            case XmlStartNamespace:
                // TODO: Implementation
                break;

            case XmlEndNamespace:
                // TODO: Implementation
                break;

            case XmlStartElement:
                XmlTreeNode.XmlTreeStartElement xmlStartElement = (XmlTreeNode.XmlTreeStartElement) node;

                // Create the new XML element

                Element newElement;

                if (xmlStartElement.getNs() != null) {
                    newElement = this.document.createElementNS(xmlStartElement.getNs(), xmlStartElement.getName());
                } else {
                    newElement = this.document.createElement(xmlStartElement.getName());
                }

                // Add the attributes

                for (XmlTreeAttribute xmlAttr : xmlStartElement.getAttributes()) {
                    // Create the new attribute

                    Attr newAttr;

                    if (xmlAttr.getNs() != null) {
                        newAttr = this.document.createAttributeNS(xmlAttr.getNs(), xmlAttr.getName());
                    } else {
                        newAttr = this.document.createAttribute(xmlAttr.getName());
                    }

                    newAttr.setValue(xmlAttr.getRawValue());

                    // Add the attribute to the element

                    newElement.setAttributeNode(newAttr);
                }

                // Add the element to the DOM

                this.nodePtr.appendChild(newElement);
                this.nodePtr = newElement;
                break;

            case XmlEndElement:
                this.nodePtr = this.nodePtr.getParentNode();
                break;

            default:
                throw new IllegalArgumentException("Unexpected resource type: " + type);
        }
    }
}
