import java.util.*;
import java.io.File;


public class Whiteboard{
	
	public static boolean isNum(String text) {
		return text.toLowerCase().contains("one") || text.toLowerCase().contains("two") || text.toLowerCase().contains("three") || text.toLowerCase().contains("four") || text.toLowerCase().contains("five") ||
		text.toLowerCase().contains("six") || text.toLowerCase().contains("seven") || text.toLowerCase().contains("eight") || text.toLowerCase().contains("nine");
	}
	
	
	public static String printNum(String text) {
		String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		int count = 0;
		for(int i = 0; i < words.length; i++) {
			if(text.contains(words[i])) {
				switch (words[i]) {
			    case "one":
			        count = 1;
			        break;
			    case "two":
			        count = 2;
			        break;
			    case "three":
			        count = 3;
			        break;
			    case "four":
			        count = 4;
			        break;
			    case "five":
			        count = 5;
			        break;
			    case "six":
			        count = 6;
			        break;
			    case "seven":
			        count = 7;
			        break;
			    case "eight":
			        count = 8;
			        break;
			    case "nine":
			        count = 9;
			        break;
			    default:
			        break;
			}
				return count + "";
			}
		} return count + "";
	}
	
	
	
	public static void main(String[] args) {
		Scanner file = null;
		try {
			file = new Scanner(new File("./src/aoc1.txt"));
		} catch(Exception e) {
			System.out.println("Cant find file");
			return;
		}
		int sum = 0;
		int lineNum = 1;
		while(file.hasNextLine()) {
			//line so I can find the errors
			System.out.println("line: " + lineNum);
			lineNum++;
			
			//text from the file
			String line = file.nextLine();
			//store a string of the numbers
			String temp = "";
			//front pointer
			int front = 0;
			//back point
			int back = line.length() - 1;
			
			while(front <= back) {
				//starts from the front and adds 1 letter each iteration
				String sub = line.substring(0, front);
				if(Character.isDigit(line.charAt(front)) || isNum(sub)) {
					if(Character.isDigit(line.charAt(front))) {
						//adds the char at the front index to the temp string
						temp += line.charAt(front);
						break;
					}
				if(isNum(sub)) {
						temp += printNum(sub);
						break;
					}
				}
				//move front index + 1
				front++;
			}
			
			//same as the front, but backwards. should stop one after back and front meet
			while (back >= front ) {
                String sub = line.substring(back);
               
                if (Character.isDigit(line.charAt(back)) || isNum(sub)) {
                    if (Character.isDigit(line.charAt(back))) {
                        temp += line.charAt(back);
                        break;
                    }
                    if(isNum(sub)) {
						temp += printNum(sub);
						break;
					}
                    
                }
                back--;
            }
			
			//assuming there's an instance where there's no number...?
			if (!temp.isEmpty()) {
				sum += Integer.parseInt(temp);
			}
		}
		System.out.println(sum);
	}

}
