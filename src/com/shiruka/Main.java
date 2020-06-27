package com.shiruka;

import com.shiruka.Clases.Dino;
import com.shiruka.Clases.Marking;
import com.shiruka.Clases.UtilClass;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static final String xmlFilePathDino = "PrimevalDinoDataXML.xml";

    public static ArrayList<Marking> markingArrayList = new ArrayList<>();
    public static ArrayList<Dino> dinoArrayList = new ArrayList<>();

    public static void main(String[] args) {
        ReadTXT();
    }

    private static void ReadTXT(){
        UtilClass Util = new UtilClass();
        markingArrayList = Util.readMarking("markings.txt");
        dinoArrayList = Util.readDino("starters.txt");
        WriteXMLDinoList();
    }

    private static void WriteXMLDinoList(){

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("root");
            document.appendChild(root);

            Element starters = document.createElement("starters");
            root.appendChild(starters);

            for (int i = 0; i < dinoArrayList.size(); i++) {
                // employee element
                Element dino = document.createElement("dino");

                starters.appendChild(dino);

                // set an attribute to staff element
                Attr Dinoattr = document.createAttribute("id");
                (Dinoattr).setValue(dinoArrayList.get(i).getId()+"");
                dino.setAttributeNode(Dinoattr);


                Element DinoName = document.createElement("name");
                DinoName.appendChild(document.createTextNode(dinoArrayList.get(i).getName()));
                dino.appendChild(DinoName);


                Element species = document.createElement("species");
                species.appendChild(document.createTextNode(dinoArrayList.get(i).getSpecies()));
                dino.appendChild(species);


                Element sex = document.createElement("sex");
                sex.appendChild(document.createTextNode(dinoArrayList.get(i).getSex()));
                dino.appendChild(sex);

                Element color = document.createElement("color");
                color.appendChild(document.createTextNode(dinoArrayList.get(i).getColor()));
                dino.appendChild(color);

                Element gen = document.createElement("gen");

                ArrayList<Marking> Mlist = dinoArrayList.get(i).getMarkings();

                for (int j = 0; j < Mlist.size(); j++) {

                    Element mark = document.createElement("dinomark");
                    gen.appendChild(mark);
                    mark.appendChild(document.createTextNode(Mlist.get(j).getId()+""));

                    gen.appendChild(mark);
                }

                Element feathered = document.createElement("feathered");
                feathered.appendChild(document.createTextNode(dinoArrayList.get(i).getIsFeathered()+""));
                dino.appendChild(feathered);

                dino.appendChild(gen);
            }

            Element markings = document.createElement("Markings");
            root.appendChild(markings);

            for (int i = 0; i < markingArrayList.size(); i++) {
                Element mark = document.createElement("mark");
                markings.appendChild(mark);

                Attr attr = document.createAttribute("id");
                (attr).setValue(markingArrayList.get(i).getId()+"");
                mark.setAttributeNode(attr);


                Element name = document.createElement("markname");
                name.appendChild(document.createTextNode(markingArrayList.get(i).getName()));
                mark.appendChild(name);


                Element attribute = document.createElement("attribute");
                attribute.appendChild(document.createTextNode(markingArrayList.get(i).getAtt()));
                mark.appendChild(attribute);


                Element chance = document.createElement("chance");
                chance.appendChild(document.createTextNode(markingArrayList.get(i).getChance()+""));
                mark.appendChild(chance);

                Element event = document.createElement("event");
                event.appendChild(document.createTextNode(markingArrayList.get(i).getEvent()));
                mark.appendChild(event);

                Element type = document.createElement("type");
                type.appendChild(document.createTextNode(markingArrayList.get(i).getType()));
                mark.appendChild(type);

                Element strength = document.createElement("strength");
                strength.appendChild(document.createTextNode(markingArrayList.get(i).getStrenght()+""));
                mark.appendChild(strength);

            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(xmlFilePathDino));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating Dino XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

}
