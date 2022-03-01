import java.io.*;

public class Logger {
    public static void Logger(String[] args) throws IOException {

            try {
                //create a buffered reader that connects to the console
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                //read a line from the console
                String lineFromInput = in.readLine();

                //create an print writer for writing to a file
                PrintWriter out = new PrintWriter(new FileWriter("output.txt",true));

                //output to the file a line
                out.println(lineFromInput);

                out.close();
            }
            catch(IOException e1) {
                System.out.println("Error during reading/writing");
            }
        }
    }

