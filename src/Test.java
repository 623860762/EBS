import sun.net.www.content.audio.basic;



public class Test {

/*
 * 将字符串中的*替换成20%；
 */

	public static String replaceChar(String s){
		char[] charArray = s.toCharArray();
		int i,j,sLen,chLen,num=0;
		sLen = charArray.length;
		for(i=0;i<sLen;i++){
			System.out.print(charArray[i]);
			if('*'==charArray[i]){
				num++;
			}
		}
		chLen=sLen+2*num;
		char[] tempChar = new char[chLen];
		for(i=sLen-1,j=chLen-1;i>=0 && j>=0;i--){
			
			if('*'==charArray[i]){
				tempChar[j--]='%';
				tempChar[j--]='0';
				tempChar[j--]='2';
			}else{
				tempChar[j]=charArray[i];
				j--;
			}
		}
		System.out.println("");
		for (int k = 0; k < tempChar.length; k++) {
			System.out.print(tempChar[k]);
		}
		return null;
/*		for(;j>=0;j--){
			if()
		}
		System.out.println(j);*/
	}
	

/*
 * 一、插入排序
 */
	public static void insertSort(int a[],int n){
		int i,j,temp;
		for(i = 1;i<n;i++){
			temp = a[i];
			for(j=i-1;j>=0 && temp<a[j];j--){
				a[j+1]=a[j];
			}
			a[j+1]=temp;
		}
	}
	
	/**
	 * 二、冒泡排序
	 */
	public static void bubbleSort(int a[],int n){
		int i,j;
		for(i=1;i<n;i++){
			for(j=0;j<n-i;j++){
				if(a[j]>a[j+1]){
					swap(a, j, j+1);
				}
			}
		}
	}
/*
 * 三、选择排序	
 */
	public static void selectSort(int a[],int n){
		int i,j,k;
		for(i=1;i<n;i++){
			k=i-1;
			for(j=i;j<n;j++){
				if(a[k]>a[j]){
					k=j;
				}
			}
			swap(a, k, i-1);
		}
	}
/*
 * 四、希尔排序	
 */

	public static void shellSort(int a[], int n)
	{
		int i, j, gap;

		for (gap = n / 2; gap > 0; gap /= 2) //步长
			for (i = 0; i < gap; i++)        //直接插入排序
			{
				for (j = i + gap; j < n; j += gap) 
					if (a[j] < a[j - gap])
					{
						int temp = a[j];
						int k = j - gap;
						while (k >= 0 && a[k] > temp)
						{
							a[k + gap] = a[k];
							k -= gap;
						}
						a[k + gap] = temp;
					}
			}
	}
	
/*
 * 无、快速排序
 */
	public static void quickSort(int a[],int low,int high){
		if(low<high){
			int povit = partion(a, low, high);
			quickSort(a, low, povit-1);
			quickSort(a, povit+1, high);
		}
	}
	
	public static int partion(int a[],int low,int high){
		int povit = a[low];
		while(low<high){
			while(low<high && a[high]>=povit)
				--high;
			a[low]=a[high];
			while(low<high && a[low]<=povit)
				++low;
			a[high]=a[low];
		}
		a[low]=povit;
		return low;
	}
/*
 * 六、堆排序	
 */
	public static void buildMaxHeap(int a[],int n){
		for (int i = n/2; i >0; i--) {
			ajustDown(a, i, n);
		}
	}
	
	public static void ajustDown(int a[],int k,int n){
		a[0]=a[k];
		for(int i=2*k;i<=n;i*=2){
			if(i<n && a[i]<a[i+1]){
				i++;
			}
			if(a[0]>=a[i]){
				break;
			}else{
				a[k]=a[i];
				k=i;
			}
		}
		a[k]=a[0];
	}
	
	public static void heapSort(int a[],int n){
		int temp;
		buildMaxHeap(a, n);
		for(int i=n;i>1;i--){
			
			temp = a[i];
			a[i]=a[1];
			a[i]=temp;
			
			ajustDown(a, 1, i-1);
		}
	}

/*
 * 归并排序
 */

	public static void MergeSort(int a[],int low,int high){
		if(low<high){
			int mid = (low+high)/2;
			MergeSort(a, low, mid);
			MergeSort(a, mid+1, high);
			Merge(a,low,mid,high);
		}
	}
	
	public static void Merge(int a[],int low,int mid,int high){
		int i,j,k;
		int[] b = new int[a.length];
		//复制a到临时数组b
		for(k=low;k<=high;k++){
			b[k]=a[k];
		}
		for(i=low,j=mid+1,k=i;i<=mid && j<=high;k++){
			if(a[i]<a[j]){
				a[k]=b[i++];
			}else{
				a[k]=b[j++];
			}
		}
		while(i<=mid){a[k]=a[i++];}
		while(j<=high){a[k]=a[j++];}
	}
/*
 * 交换函数
 */
	public static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
/*
 * 打印数组函数	
 */
	public static int getMaxNum(int a[],int n){
		int Len = 1;a[0]=1;
		for(int i=1;i<n;i++){
			
			for(int j=i+1;j<=n;j++){
				a[0]
			}
		}
		return -1;
	}
	public static void printArray(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
		System.out.println("------------------");
	}
	public static void main(String[] args) {
		int a[] = {0,20,18,22,16,30};
		MergeSort(a, 0, 5);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
/*		String s = "sdss*ss*s*ss*****ff**fff***fffffff******";
		replaceChar(s);*/
		
		
	}

}
