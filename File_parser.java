
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;

public class File_parser
{

  static ArrayList<String> lines = new ArrayList<>();;
  static ArrayList<String> sents = new ArrayList<>();;

  public static void file_reader()
  {
            BufferedReader reader = null;
            BufferedReader reader1 = null;
            String input = "Movie_reviews.txt";
            String input1 = "Movie_reviews_sent.txt";
            try
            {
            File file = new File(input);
            File file1 = new File(input1);

            reader = new BufferedReader(new FileReader(file));
            reader1 = new BufferedReader(new FileReader(file1));

            String line;
            while ((line = reader.readLine()) != null) {
                if(line.equals(" ")){
                  continue;
                }
                lines.add(line);

                }
            String sent;
            while ((sent = reader1.readLine()) != null) {
                if (!sent.contains("0") && !sent.contains("0.5") && !sent.contains("1") && !sent.contains("-0.5") && !sent.contains("-1")) {
                  continue;
                }
                sents.add(sent);

                }



            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();


                    }
                    if (reader1 != null){
                      reader1.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }





  }
  public static void main(String[] args)
  {
      file_reader();
      try{
        FileWriter writter = new FileWriter("pos_movie_rews.txt");
        BufferedWriter bw = new BufferedWriter(writter);
        FileWriter writter1 = new FileWriter("neg_movie_rews.txt");
        BufferedWriter bw1 = new BufferedWriter(writter1);
        //System.out.println(lines.size());
        //System.out.println(sents.size());
        for (int i=0; i<lines.size() ;i++ ) {
          String a = sents.get(i);
        //  System.out.println(a);
          if(Float.parseFloat(a) > 0) {
              bw.write(lines.get(i)+"\n");
          }else if(Float.parseFloat(sents.get(i)) < 0) {
              bw1.write(lines.get(i)+"\n");
        }
      }
      }catch (Exception e) {

        e.printStackTrace();

        }
        /*for (int i=0;i<lines.size() ;i++ ) {
          int a = neglines.get(i).indexOf("word1=");
          int b = neglines.get(i).indexOf("pos1=");
          bw1.write(neglines.get(i).substring(a+6,b-1)+"\n");
        }*/
      /*}catch (Exception e) {

			e.printStackTrace();

		  }finally {
        try { if (bw!=null)
                  //bw.close();
                  //bw1.close();
                  //writter.close();
                  //writter1.close();
            } catch (Exception e) {

				e.printStackTrace();

			}*/


  }






}
