package testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TestingCollectionGenerics {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		List yolo = new ArrayList();
		yolo.add("yo");
		yolo.add("yolo");
		displayList1(yolo);
		displayList(yolo);
	}
	
	public static void displayList1(List<Integer> yolo)
	{
		for(Object string : yolo)
			System.out.println(string);
	}
	
	public static void displayList(List<Integer> yolo)
	{
		for(Integer string : yolo)
			System.out.println(string);
	}
	
	
	
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * Animal animal = new Animal(); System.out.println(animal instanceof Dog);
	 * System.out.println(animal instanceof Cat); System.out.println(animal
	 * instanceof Animal); animal.run(); animal = new Dog();
	 * System.out.println(animal instanceof Dog); System.out.println(animal
	 * instanceof Cat); System.out.println(animal instanceof Animal); animal.run();
	 * animal = new Cat(); System.out.println(animal instanceof Dog);
	 * System.out.println(animal instanceof Cat); System.out.println(animal
	 * instanceof Animal); animal.run();
	 * 
	 * }
	 */

	// Write your code here
	/*
	 * 
	 * public static void main(String[] args) throws IOException { BufferedReader
	 * bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	 * BufferedWriter bufferedWriter = new BufferedWriter(new
	 * FileWriter(System.getenv("OUTPUT_PATH")));
	 * 
	 * int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());
	 * 
	 * List<Integer> requestTime = IntStream.range(0, requestTimeCount).mapToObj(i
	 * -> { try { return bufferedReader.readLine().replaceAll("\\s+$", ""); } catch
	 * (IOException ex) { throw new RuntimeException(ex); } }) .map(String::trim)
	 * .map(Integer::parseInt) .collect(toList());
	 * 
	 * int result = droppedRequests(requestTime);
	 * 
	 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
	 * 
	 * bufferedReader.close(); bufferedWriter.close(); }
	 * 
	 * 
	 * public static int droppedRequests(List<Integer> requestTime) { // Write your
	 * code here
	 * 
	 * 
	 * int lastTenSecond = 0; int lastMinute = 0; ArrayList<Integer>
	 * numberPacketLastMinute = new ArrayList<Integer>();
	 * Collections.sort(requestTime); int currentPacketTime = 0; int
	 * currentSecondPacket = 0; int dropPackets = 0; for(Integer requestPacketTime :
	 * requestTime) {
	 * 
	 * if(requestPacketTime==currentPacketTime) { if(lastTenSecond>=20 ||
	 * lastMinute>=60|| currentSecondPacket>=3) { System.out.println("1 " +
	 * dropPackets + " " + requestPacketTime); dropPackets++; currentSecondPacket++;
	 * lastTenSecond++; lastMinute++; numberPacketLastMinute.remove(0);
	 * numberPacketLastMinute.add(0, currentSecondPacket); } else { lastTenSecond++;
	 * lastMinute++; currentSecondPacket++; numberPacketLastMinute.remove(0);
	 * numberPacketLastMinute.add(0, currentSecondPacket); } } else
	 * if(requestPacketTime==currentPacketTime+1) { currentPacketTime++;
	 * currentSecondPacket=0; if(numberPacketLastMinute.size()>=10) {
	 * if(lastTenSecond>numberPacketLastMinute.get(9))
	 * lastTenSecond-=numberPacketLastMinute.get(9); else lastTenSecond=0; }
	 * if(numberPacketLastMinute.size()>=60) {
	 * if(lastTenSecond>numberPacketLastMinute.get(59))
	 * lastMinute-=numberPacketLastMinute.get(59); else lastMinute=0; }
	 * numberPacketLastMinute.add(0, 1); if(lastTenSecond>=20 || lastMinute>=60||
	 * currentSecondPacket>=3) { System.out.println("2 " + dropPackets + " " +
	 * requestPacketTime); dropPackets++; currentSecondPacket++; lastTenSecond++;
	 * lastMinute++; numberPacketLastMinute.remove(0); numberPacketLastMinute.add(0,
	 * currentSecondPacket); } else { lastTenSecond++; lastTenSecond++;
	 * currentSecondPacket++; numberPacketLastMinute.remove(0);
	 * numberPacketLastMinute.add(0, currentSecondPacket); } } else {
	 * currentSecondPacket=0; if(numberPacketLastMinute.size()>=10) {
	 * if(lastTenSecond>numberPacketLastMinute.get(9))
	 * lastTenSecond-=numberPacketLastMinute.get(9); else lastTenSecond=0; }
	 * if(numberPacketLastMinute.size()>=60) {
	 * if(lastTenSecond>numberPacketLastMinute.get(59))
	 * lastMinute-=numberPacketLastMinute.get(59); else lastMinute=0; }
	 * numberPacketLastMinute.add(0, 0); currentPacketTime++; } } return
	 * dropPackets; }
	 * 
	 */

}
