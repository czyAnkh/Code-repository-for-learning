#include<iostream>
using namespace std;
//�������״̬����
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2

//�궨��ĩβ��Ҫ�ӷֺţ�
#define MAXSIZE 100

//����int�ɸ�Ϊ��������
typedef int ElemType;

//Status �Ǻ��������ͣ���ֵ�Ǻ��������״̬������OK��ERROR��
typedef int Status;

typedef struct{
	ElemType *data;//�˴�Ҳ����elem[MAXSIZE}
	int length;
}SqList;//SequenceList

//��ʼ�����Ա�
Status InitList_Sq(SqList& L) {
	L.data = new ElemType[MAXSIZE];//����һ����СΪMAXSIZE�Ŀռ�
	if (!L.data) exit(OVERFLOW);//�������ʧ�����˳�
	L.length = 0;//�ձ��ȳ�ʼ��Ϊ0
	return OK;
}

//�������Ա�



int main()
{

}