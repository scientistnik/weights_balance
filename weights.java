import java.util.Scanner;

public class weights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i[] = new int[100];
		int quant;
		String word = sc.nextLine();
		sc = new Scanner(word);
		for(quant = 0; sc.hasNextInt(); quant++) {
			i[quant] = sc.nextInt();
		}
		int numbers[] = new int[quant];
		int sum = 0;
		for (int j=0; j < quant; j++) {
			numbers[j] = i[j];
			sum += i[j];
		}
		if (sum%2 != 0) System.out.println("Impossible...");
		else {
			boolean index[];
			index = Check(sum/2, numbers);
			boolean yes = false;
			for (int j=0; (j < numbers.length) && yes ==false; j++) 
				if (index[j]) yes = true;
			if (yes) {
				for (int j=0; j < numbers.length; j++) 
					if (index[j]) System.out.print(" "+numbers[j]);	
				System.out.print(" -");
				for (int j=0; j < numbers.length; j++) 
					if (index[j]==false) System.out.print(" "+numbers[j]);	
				System.out.println(" ");
			}
			else System.out.println("No");
			index = Check(100, numbers);
			yes = false;
			for (int j=0; (j < numbers.length) && yes ==false; j++) 
				if (index[j]) yes = true;
			if (yes) System.out.print("Yes");
			else System.out.print("No");
		}
	}
	static boolean [] Check(int num, int elem[]) {
		int i = 1;
		int sum = elem[0];
		boolean index[] = new boolean[elem.length];
		index[0] = true;
		while(i!=0) {
			if (i >= elem.length) {
				i--;
				while(index[i] != true) i--;
				if (i == 0) {
					//System.out.println("No");
					index[0] = false;
					break;
				}
				else {
					index[i] = false;
					sum -= elem[i];
				}
			}
			else {
				sum +=elem[i];
				index[i] = true;
				if (sum == num) break;
				else if (sum > num) {
					index[i] = false;
					sum -=elem[i];
				}
			}
			i++;
		}
		return index;
	}
}