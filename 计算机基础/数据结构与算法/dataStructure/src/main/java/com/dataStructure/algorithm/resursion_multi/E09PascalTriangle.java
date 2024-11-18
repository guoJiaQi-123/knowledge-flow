package com.dataStructure.algorithm.resursion_multi;


/**
 * 杨辉三角
 */
// 定义一个E09PascalTriangle类
public class E09PascalTriangle {

    // 定义一个element方法，用来计算元素
    private static int element(int i,int j){

        // 如果i等于j或者j等于0，返回1
        if(i==j||j==0){
            return 1;
        }

        // 否则返回element(i-1,j-1)+element(i-1,j)
        return element(i-1,j-1)+element(i-1,j);

    }
    // 定义一个printSpace方法，用来打印空格
    private static void printSpace(int n,int i){
        // 计算空格的数量
        int num = (n-1-i)*2;
        // 循环打印空格
        for(int j=0;j<num;j++){
            System.out.print(" ");
        }
    }

    // 定义一个print方法，用来打印 Pascal 三角
    private static void print(int n){
        // 循环打印 控制行
        for(int i=0;i<n;i++){
            // 打印空格
            printSpace(n,i);
            // 循环打印元素  控制列
            for(int j=0;j<=i;j++){
                System.out.printf("%-4d",element(i,j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 调用print方法，打印 Pascal 三角
        print(15);

    }

}

/**
 * 杨辉三角优化1-使用二维数组记忆法
 */
class E09PascalTriangle_Mnemonics {

    // 定义一个element方法，用来计算元素 使用二维数组记忆法cachedArrays缓存二维数组
    private static int element(int[][] cachedArrays,int i,int j){

        // 如果缓存中有值，直接返回，不在进行下面的计算
        if(cachedArrays[i][j] > 0){
            return cachedArrays[i][j];
        }


        // 如果i等于j或者j等于0，返回1
        if(i==j||j==0){
            cachedArrays[i][j] = 1;
            return 1;
        }
        // 否则返回element(i-1,j-1)+element(i-1,j)
        cachedArrays[i][j]=element(cachedArrays,i-1,j-1)+element(cachedArrays,i-1,j);
        // 否则返回element(i-1,j-1)+element(i-1,j)
        return cachedArrays[i][j];

    }
    // 定义一个printSpace方法，用来打印空格
    private static void printSpace(int n,int i){
        // 计算空格的数量
        int num = (n-1-i)*2;
        // 循环打印空格
        for(int j=0;j<num;j++){
            System.out.print(" ");
        }
    }

    // 定义一个print方法，用来打印 Pascal 三角
    private static void print(int n){
        //定义一个缓存数组，用来记录已经计算过的值
        int[][] cachedArrays = new int[n][];
        // 循环打印 控制行
        for(int i=0;i<n;i++){
            cachedArrays[i] = new int[i+1];
            // 打印空格
            printSpace(n,i);
            // 循环打印元素  控制列
            for(int j=0;j<=i;j++){
                System.out.printf("%-4d",element(cachedArrays,i,j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 调用print方法，打印 Pascal 三角

        print(15);

    }

}

/**
 * 一维数组，节省空间复杂度
 */
class E09PascalTriangle_Mnemonics2 {


    // 定义一个printSpace方法，用来打印空格
    private static void printSpace(int n,int i){
        // 计算空格的数量
        int num = (n-1-i)*2;
        // 循环打印空格
        for(int j=0;j<num;j++){
            System.out.print(" ");
        }
    }

    // 定义一个print方法，用来打印 Pascal 三角
    private static void print(int n){
        int[] row = new int[n];
        // 循环打印 控制行
        for(int i=0;i<n;i++){
            // 生成行
            creatRow(row,i);
            // 打印空格
            printSpace(n,i);
            // 循环打印元素  控制列
            for(int j=0;j<=i;j++){
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }

    /**
     * 生成行
     * @param row 一维数组
     * @param i 行号
     */
    private static void creatRow(int[] row,int i){

        // 如果是第一行，则第一个元素为1
        if(i==0){
            row[0] = 1;
        }

        // 从后往前遍历，计算每一行的元素
        for (int j = i; j > 0; j--) {
            row[j] = row[j]+row[j-1];
        }

    }

    public static void main(String[] args) {
        // 调用print方法，打印 Pascal 三角

        print(5);

    }

}