package question3;

public class Main {
	
	public static void main(String args[])throws Exception {
		Data data=new Data();
		double[][] trainingData=data.readData(1);
		double[][] testData=new double[10][3];
		testData=data.readData(2);
		GradientDecent gd=new GradientDecent(trainingData);
		gd.doGradiant();
		for(int i=0;i<10;i++){
			testData[i][2]=g(gd.theta[0]+gd.theta[1]*testData[i][1]+gd.theta[2]*testData[i][2]);
			Double answer=new Double(testData[i][2]);
			for(int j=0;j<gd.theta.length;j++){
				if(j==2)
					System.out.print(answer.intValue()+"\t");
				else
					System.out.print(testData[i][j]+"\t");
			}
			System.out.println();
		}
		for(int i=0;i<gd.theta.length;i++){
			System.out.println("theta["+i+"]="+gd.theta[i]);
		}
				}
	public static double g(double z){
		z=(1/(1+Math.exp(-1*z)));
		return z;
	}
}

