import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TagGenerator {

    private static void generate(ArrayList<String> sourceList, String destination) {
        try {

            File file = new File("BET_TEMPLATE.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            Node query = doc.getFirstChild();

            for (String source : sourceList) {
                
                Element sourceElement = doc.createElement("source");
                sourceElement.appendChild(doc.createTextNode(source));
                query.appendChild(sourceElement);
            }

            NodeList formats = doc.getElementsByTagName("format");

            for (int i = 0; i < formats.getLength(); i++) {
                Node format = formats.item(i);
                NodeList formatKids = format.getChildNodes();
                for (int j = 0; j < formatKids.getLength(); j++) {
                    Node fKid = formatKids.item(j);
                    if ("destination".equals(fKid.getNodeName())) {
                        fKid.setTextContent(destination);
                    }
                }

            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("BET.xml"));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        ArrayList<String> sourceList = new ArrayList<String>();
       
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first source: ");
        String firstSource = in.nextLine();
        
        System.out.println("Enter the second source: ");
        String secondSource = in.nextLine();

        System.out.println("Enter the third source: ");
        String thirdSource = in.nextLine();
        
        System.out.println("Enter replacement text for the middle source: ");
        String secReplaceText = in.nextLine();
        
        int beginTagIndex = secondSource.indexOf("<tag>");
        int endTagIndex = secondSource.lastIndexOf('>');
        String toReplace = secondSource.substring(beginTagIndex, endTagIndex+1);
        secondSource = secondSource.replaceAll(toReplace, secReplaceText);
        
        System.out.println(secondSource);
        
        sourceList.add(firstSource);
        sourceList.add(secondSource);
        sourceList.add(thirdSource);
        
        
        System.out.println("Enter the destination: ");
        String destination = in.nextLine();

        System.out.println("Enter the destination replacement text: ");
        String desReplaceText = in.nextLine();
        
        
        
        
        //TagGenerator.generate(sourceList, desReplaceText);

        in.close();

    }

}
