// ���е����Ӵ洢ͷ�ļ�
// ����ѭ���������и���ͷ�ڵ㣬ʹ��β���ָ��
// CLQ_   Circularly Linked Queue
////////////////////////////////////////
#if !defined(LINKED_QUEUE_H_983982)
#define LINKED_QUEUE_H_983982

typedef int QElemType;

typedef struct Qnode {
	QElemType   data;
	struct Qnode* next;
}Qnode, * QueuePtr;
typedef struct {
	QueuePtr  front;            //��ͷָ��   
	QueuePtr  rear;             //��βָ��
}LinkQueue;

void CLQ_Create(LinkQueue& Q);
void CLQ_Free(LinkQueue& Q);
void CLQ_MakeEmpty(LinkQueue& Q);
bool CLQ_IsEmpty(LinkQueue Q);
int CLQ_Length(LinkQueue Q);
void CLQ_In(LinkQueue& Q, QElemType  x);
bool CLQ_Out(LinkQueue& Q, QElemType& item);
bool CLQ_Head(LinkQueue& Q, QElemType& item);
void CLQ_Print(LinkQueue& Q);
#endif
//////////////////////////////////////////