package question1;

public class Main {
	
	public static void main(String args[])throws Exception {
		Data data=new Data();
		double[] answer = new double[10];
		double[][] trainingData=data.readData(1);
		double[][] testData=new double[10][3];
		testData=data.readData(2);
		GradientDecent gd=new GradientDecent(trainingData);
		gd.doGradiant();
		for(int i=0;i<10;i++){
			testData[i][2]=(gd.theta[0]+gd.theta[1]*testData[i][0]+gd.theta[2]*testData[i][1]);
			for(int j=0;j<3;j++){				                                                                              
				System.out.print(testData[i][j]+"\t");
			}
			System.out.println();
		}
	}
}