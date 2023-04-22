#include<iostream>
using namespace std;
//函数结果状态代码
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2

//宏定义末尾不要加分号！
#define MAXSIZE 100

//其中int可改为其他类型
typedef int ElemType;

//Status 是函数的类型，其值是函数结果的状态代码如OK，ERROR等
typedef int Status;

typedef struct{
	ElemType *data;//此处也可用elem[MAXSIZE}
	int length;
}SqList;//SequenceList

//初始化线性表
Status InitList_Sq(SqList& L) {
	L.data = new ElemType[MAXSIZE];//分配一个大小为MAXSIZE的空间
	if (!L.data) exit(OVERFLOW);//储存分配失败则退出
	L.length = 0;//空表长度初始化为0
	return OK;
}

//销毁线性表



int main()
{

}