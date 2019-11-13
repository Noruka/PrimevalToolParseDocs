package com.shiruka.Clases;

import java.io.*;
import java.util.ArrayList;

public class UtilClass {

    public ArrayList<Marking> marklist = new ArrayList<>();
    public ArrayList<Dino> dinolist = new ArrayList<>();

    public ArrayList<Marking> readMarking(String pathname){

        try
        {
        File file = new File(pathname);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        int contador = 0;

        while ((st = br.readLine()) != null)
        {
            contador++;
            String[] markInfo = st.split("-");

            Marking mark = new Marking();

            mark.setId(contador);
            mark.setName(markInfo[0]);
            mark.setAtt(markInfo[1]);
            mark.setChance(Integer.parseInt(markInfo[2]));
            mark.setEvent("base");
            String type;

            switch (mark.getChance()){

                case 40:
                    type="common";
                    break;
                case 25:
                    type ="uncommon";
                    break;
                case 15:
                    type= "rare";
                    break;
                default:
                    type="common";
                    break;
            }

            mark.setType(type);

            marklist.add(mark);

        }
        }catch (Exception e){

            System.out.println("Error:"+e.getMessage());

        }finally {
            return marklist;
        }
    }

    public ArrayList<Dino> readDino(String pathname){

        try
        {
        File file = new File(pathname);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;



        while ((st = br.readLine()) != null)
        {

            String[] dinoInfo = st.split("-");

            Dino dino = new Dino();

            dino.setName(dinoInfo[0]);
            dino.setId(Integer.parseInt(dinoInfo[1]));
            dino.setSpecies(dinoInfo[2]);
            dino.setSex(dinoInfo[3]);
            dino.setColor(dinoInfo[4]);
            dino.setMarkings(AddMarkings(GenoListArray(dinoInfo[5]), marklist));

            dinolist.add(dino);

        }

        }catch (Exception e){

            System.out.println("Error:"+e.getMessage());

        }finally {
            return dinolist;
        }
    }

    public ArrayList<Marking> AddMarkings(String[] marks, ArrayList<Marking> MarkingList)
    {

        var Mlist = new ArrayList<Marking>();

        for (var i = 0; i < MarkingList.size(); i++) {
            for (var j = 0; j < marks.length; j++) {
                if (MarkingList.get(i).getAtt().equals(marks[j])) {
                    Mlist.add(MarkingList.get(i));
                }
            }
        }

        return Mlist;
    }

    public String[] GenoListArray(String markings)
    {
        var list = markings.split("/");

        for (var i = 0; i < list.length; i++)
        {
            list[i] = list[i].strip();
        }

        return list;
    }

    private void createFile(String file, ArrayList<String> arrData)
            throws IOException {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i);
            writer.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
            writer.write("\n");
        }
        writer.close();
    }

}


