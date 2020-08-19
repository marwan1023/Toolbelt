package MMU;

/* Marcus Johnson
   Operating Systems
   Programming Assignment 3 */



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import corejava.Console;


public class Link
{
	// Declare integer variables for size, status, addresses,and index and linked lists
	public int nstatus;
	public int nprocess_id;
	public int nsize;
	public int nstart_address;
	public int nend_address;
	public int nvalue;
	public Link lnext;

// Function that builds the linked lists
public Link (int npid ,int size, int nalgorithm_type,
			int nindex,Link in,int end_address)
{

nprocess_id=npid;
if (npid>0)
	nstatus=1;
else
nstatus=0;
nsize=size;
nvalue=nindex;
lnext=in;
nend_address=end_address;
nstart_address=end_address-size;
}

// Main function
public static void main(String arg[])
{

	// Declare variables for the input file
	String line;
	BufferedReader in = null;
	StringTokenizer tok;

	// Declare variables for the linked list, process id, node, and the number of free spaces
	Link head = null;
	int quit =0;
	int PID;
	int Operation;
	int node=0;
	int numb_of_empty=0;
	// This while loop reads in data from the file and applies that data to each of the three algorithms
	while(quit==0){
		// Initialize index, Size, the end address, and the free space count
		int linkindex=0;
		int Size=0;
		int endaddress=0;
		numb_of_empty=0;

		// Create selection statements that allows user to read in a choice for a specific algorithm
		System.out.println ("Choose an algorithm:");
		System.out.println ("(1 for first-fit)");
		System.out.println ("(2 for best-fit)");
		int algorithm_type = Console.readInt("(3 for worst-fit)");
		System.out.println("\n" + "Algorithm chosen is ");
		if (algorithm_type == 1)
			System.out.print("first fit.\n");
			else if (algorithm_type == 2)
			System.out.print("best fit.\n");
			else if (algorithm_type == 3)
			System.out.print("worst fit.\n\n");
        System.out.println("***************Output****************");
		// Read data file attempt
		try {
		   // new FileReader("input3.dat")
		    
			try {
                in = new BufferedReader (new InputStreamReader(
                        new FileInputStream("input3.dat"), "UTF8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			}
		catch(FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
			}
		try {
		// Attempt to process information for the algorithms while the data file has not reached the end
		while((line = in.readLine()) != null){
			tok = new StringTokenizer(line);
			PID = Integer.parseInt(tok.nextToken());

			// Print out the appropriate information when the process id is 0
			if(PID==0){
				// Declare integer arrays that represent the status, process id, size, and
				// the start and ending addresses
				int Astatus[]= new int [node+numb_of_empty];
				int Aproc_id[]= new int[node+numb_of_empty];
				int Asize[]= new int[node+numb_of_empty];
				int Astart_address[]= new int[node+numb_of_empty];
				int Aend_address[]= new int[node+numb_of_empty];
				Link p = head;
				System.out.println("STATUS	PROC	SIZE	START	END");
				System.out.println("-----------------------------------");
				int j;

				// Set array index values equal to the status, id,size, start address and end address of
				// the linked list
				for (j=0;p !=null;j++) {
					Astatus[j]=p.nstatus;
					Aproc_id[j]=p.nprocess_id;
					Asize[j]=p.nsize;
					Astart_address[j]=p.nstart_address;
					Aend_address[j]=p.nend_address;
					p = p.lnext;
					}
				j--;
				while (j>=0) {
					// Check for free and used space
					if (Astatus[j]==0)
						System.out.print("Free	");
					else
						System.out.print("Used	");
					if (Astatus[j]==1)
						System.out.print(Aproc_id[j]);
					else
						System.out.print("--");
					// Print out size, start address, and end address
					System.out.println("	"+Asize[j]+"	"+Astart_address[j]+"	"+Aend_address[j]);
					j--;
					}
				System.out.println();
				}
			// This if statement will be responsible for finding -1 and it will compact the remaining
			// space in memory
			else if (PID==-1){
					// Declare links and initialize flag variables and the emptyspace
					int emptyspace=0;
					Link newaddress;
					Link lastaddrees=head;
					Link h=head;
					int flag2 = 0;
					int Aeindex[]=new int[numb_of_empty];
					int Aesize[]=new int[numb_of_empty];
					int k=0;
					// This while loop allocates the space in the linked list for compacting
					while (h!=null){
						if (h.nstatus==0){
								if (h == head){
									    flag2 = 1;
									    emptyspace=emptyspace+h.nsize;
										}
							    else {
								Aeindex[k]=h.nvalue;
								Aesize[k]=h.nsize;
								k++;
								emptyspace=emptyspace+h.nsize;
								newaddress=h.lnext;
								h=lastaddrees;
								h.lnext=newaddress;
								node--;
								 }



							}
						else
							lastaddrees=h;
						h=h.lnext;

					}

					if (emptyspace>0){
						h=head;
						int i;
						int temptysize=0;
						k--;
						// While the head of the linked list is not null, this will set the start and end
						// addresses for the algorithms by subtracting the start and end addresses from
						// the array size number. Afterwards, the head will be moved to the next item in
						// list.
					    while (h!=null){
							temptysize=0;
							//System.out.println("k ="+k);
							for (i=k;i>=0;i--){
								if (Aeindex[i]<h.nvalue){
								//System.out.println(Aeindex[i]);
								temptysize=temptysize+Aesize[i];
								}
								}

								//System.out.println("hello");
								h.nstart_address=h.nstart_address-temptysize;
								h.nend_address=h.nend_address-temptysize;
								h=h.lnext;

							}
						h=head;
						endaddress=h.nend_address;
						// If this flag is 0, this if statement sets the head linked list to
						// a new linked list
						if (flag2 == 0){
							head = new Link(0,emptyspace,algorithm_type,linkindex,head,endaddress+emptyspace);
						}
						// If not, reset all linked list variables
						else{
							h.nstatus = 0;
							h.nsize = emptyspace;
							h.nvalue = linkindex;
							h.nend_address = emptyspace;
							}
						node++;
						numb_of_empty=1;
						}
				}
			else {
				// This declaration and following if statement obtains the operaton number
				Operation = Integer.parseInt(tok.nextToken());
				if (Operation==0){
					Link d = head;
					while (d.nprocess_id != PID)
					d=d.lnext;
					d.nstatus=0;
					numb_of_empty++;
					}
				else {
						// Obtain the Size
						Size = Integer.parseInt(tok.nextToken());
						Link d = head;
						int Aeindex2[]=new int [numb_of_empty];
						int Aesize2[]=new int [numb_of_empty];
						int flag=0;
						int g=numb_of_empty;
						while (d !=null){

								if (d.nstatus==0){g--;
									Aeindex2[g]=d.nvalue;
									Aesize2[g]=d.nsize;

									// This if statement actually handles the compaction for first fit
									if (algorithm_type == 1 && Size<=d.nsize){

											d.nprocess_id=PID;
											d.nstatus=1;
											flag=1;
											numb_of_empty--;

										}


									}
									d=d.lnext;
							}

							// Compaction for best fit
							if (algorithm_type == 2){d = head;

								int min=1000000;//d.nsize;
								int minnumb=0;
								int l=0;
								for (l=numb_of_empty-1;l>=0;l--){
								if (Aesize2[l]<min){
								min=Aesize2[l];
								minnumb=l;

								}

								}

									int x=numb_of_empty-1;
									while (d !=null){
									if (d.nstatus==0){
									if (x==minnumb){
									d.nprocess_id=PID;
									System.out.println("index"+d.nvalue);
									d.nstatus=1;
									flag=1;
									numb_of_empty--;
									}
									x--;
									}
									d=d.lnext;
									}

								}
							// Compaction for worst fit
							if (algorithm_type == 3){d = head;
									int max=0;
									int maxn=0;
									int n=0;

									for (n=numb_of_empty-1;n>=0;n--){
										if (Aesize2[n]>max){
											max=Aesize2[n];
											maxn=n;
											}
										}


									int b=numb_of_empty-1;
									while (d !=null){

										if (d.nstatus==0){
											if (b==maxn){

												d.nprocess_id=PID;
												d.nstatus=1;
												flag=1;
												numb_of_empty--;
												}
											b--;
											}
										d=d.lnext;
										}

									}
							// If this flag is 0, this if statement sets the head linked list to
						// a new linked list, reset the end address, and increment the node value
							if (flag==0){
							endaddress=endaddress+Size;
							head = new Link(PID,Size,algorithm_type,linkindex,head,endaddress);
							node++;
						}


					}
				}
			linkindex++;
			}

		}
	catch(IOException e) {
		System.out.println("Error: " + e.toString());
		}
		head = null;
		quit = Console.readInt("(Press 0 to resume, 1 to quit)");
	}
}

}