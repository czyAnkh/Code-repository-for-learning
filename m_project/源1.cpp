// ���е����Ӵ洢ʵ���ļ���
// ����ѭ���������и���ͷ�ڵ㣬ʹ��β���ָ�롣
// CLQ_   Circularly Linked Queue
////////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
#include "CLnkQueue.h"
void CLQ_Create(LinkQueue& Q)
// ����һ�����С�
{
    Q.front = Q.rear = new Qnode;
    Q.front->next = NULL;
    Q.front->data = 0;
}
void CLQ_Free(LinkQueue& Q)
{
    while (Q.front)
    {
        Q.rear = Q.front->next;
        free(Q.front);
        Q.front = Q.rear;
    }

}
void CLQ_MakeEmpty(LinkQueue& Q)
// rearָ��β��㡣
// �����б�Ϊ�ն��С�
{
    QElemType  item;
    while (!CLQ_IsEmpty(Q))
        CLQ_Out(Q, item);
}
bool CLQ_IsEmpty(LinkQueue Q)
// �ж϶����Ƿ�Ϊ�ա�
{
    // ����Begin-End֮�䲹����룬��ɶ����Ƿ�Ϊ�յ��жϡ�
    /********** Begin *********/
    return Q.front->data == 0;

        /********** End **********/
}
int CLQ_Length(LinkQueue Q)
// ���ض��г��ȣ�rearָ��β��㡣
{
    // ����Begin-End֮�䲹����룬��ȡ���г��ȡ�
    /********** Begin *********/
    return Q.front->data;

    /********** End **********/
}
void CLQ_In(LinkQueue& Q, QElemType  x)
// �����, �½���������β����rearָ��β��㡣
{
    // ����Begin-End֮�䲹����룬����½����Ӳ�����
    /********** Begin *********/
    Qnode* p = (Qnode*)malloc(sizeof(Qnode));
    //if (Q.front->next == NULL) Q.front = Q.rear;
    p->data = x;
    p->next = Q.rear->next;
    Q.rear->next = p;
    Q.rear = p;
    Q.front->data++; 
    /********** End **********/
}
bool CLQ_Out(LinkQueue& Q, QElemType& item)
// �����С��ն���ʱ������ֵΪfalse��rearָ��β��㡣
{
    // ����Begin-End֮�䲹����룬��ɽ����Ӳ�����
    /********** Begin *********/
    if (CLQ_IsEmpty(Q)) return false;
    if (Q.front->next->next != NULL) {
        item = Q.front->next->data;
        Q.front->next = Q.front->next->next;
        Q.front->data--;
    }
    else {
        Q.front = Q.rear;
        Q.front->next = NULL;
        Q.front->data = 0;
    }
    /********** End **********/
}
bool CLQ_Head(LinkQueue& Q, QElemType& item)
// rearָ��β��㡣
// ��ȡ����ͷ���ն���ʱ����ֵΪfalse��
{
    if (CLQ_IsEmpty(Q))
    {
        return false;
    }
       

    item = Q.front->next->data;
    return true;
}
void CLQ_Print(LinkQueue& Q)
// ��ӡ���С�
{
    if (CLQ_IsEmpty(Q)) {
        printf("The queue is: empty. \n");
        return;
    }
    Qnode* node = Q.front->next;
    do {
        printf("%d  ", node->data);
        node = node->next;
    } while (node != Q.rear->next);
    //printf("\n");
}

