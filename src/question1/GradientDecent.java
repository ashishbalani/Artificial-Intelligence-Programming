package question1;

import java.util.Random;

public class GradientDecent {
	
	public double[][] trainingData;
	public int maxIteration=100;
	public double alpha=0.01D;
	public double[] theta;
	public Random random=new Random();
	public double[][] x=new double[10][2];
	public double[] y=new double[10];
	
	public GradientDecent(double[][] trainingData){
		this.trainingData=trainingData;
		initVariables();
	}
	
	public void initVariables(){
		theta=new double[3];
		x=new double[10][3];
		y=new double[10];
		for (int i=0;i<theta.length;i++){
			theta[i]=(random.nextInt(10));
		}
		for(int i=0;i<10;i++){
			x[i][0]=1;
			x[i][1]=trainingData[i][1];
			x[i][2]=trainingData[i][2];
			y[i]=trainingData[i][2];
		}
		
	}
	
	public void doGradiant(){
		double[] gradient=new double[10];
		double grad=0.0D;
			for(int i=0;i<maxIteration;i++){
			
			for(int j=0;j<10;j++){
				gradient[j]=(theta[0]*x[j][0]+x[j][1]*theta[1]+x[j][2]*theta[2])-y[j];
			}
			
			for(int j=0;j<10;j++){
				for(int k=0;k<theta.length;k++){
				this.theta[k]=(this.theta[k] - this.alpha*gradient[j]*x[j][k]);
				}	
			}
			
			for(int j=0;j<10;j++){
			grad=grad+Math.abs(gradient[j]*gradient[j]) ;
			}
			
			
			if(grad<=1.e-10){
			break;
			}							
		}
	}
	
	public void calculateError(){
		
		
	}
}
