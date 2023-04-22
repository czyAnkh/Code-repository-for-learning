// 队列的链接存储头文件
// 采用循环链表，具有附加头节点，使用尾结点指针
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
	QueuePtr  front;            //队头指针   
	QueuePtr  rear;             //队尾指针
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