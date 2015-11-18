import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Gui
{
	static String file;
	/**This class is (came from online) it delete's line that user wants to delete
	 */
	public void removeLineFromFile(String file, String lineToRemove)
	{		 
		try
		{ 
			File inFile = new File(file);

			if (!inFile.isFile())
			{
				System.out.println("Parameter is not an existing file");
				return;
			}
			/**Construct the new file that will later be renamed to the original filename. 
			 */
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			/**takes in the old file and reads it
			 */
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			/**new print writer to write the temporary file which is getting passed in
			 */
			String line = null;
			/**Read from the original file and write to the new 
			 * unless content matches data to be removed.
			 */
			while ((line = br.readLine()) != null)
			{/**this loop reads all lines until it comes across the line that has to be deleted
			*/
				if (!line.trim().equals(lineToRemove))
				{
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();
			/**Delete the original file if it can be done
			 */
			if (!inFile.delete())
			{
				System.out.println("Could not delete file");
				return;
			}       
			/**Rename the new file to the filename the original file had.
			 */
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}