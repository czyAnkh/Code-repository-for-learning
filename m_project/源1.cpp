// 队列的链接存储实现文件。
// 采用循环链表，具有附加头节点，使用尾结点指针。
// CLQ_   Circularly Linked Queue
////////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
#include "CLnkQueue.h"
void CLQ_Create(LinkQueue& Q)
// 创建一个队列。
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
// rear指向尾结点。
// 将队列变为空队列。
{
    QElemType  item;
    while (!CLQ_IsEmpty(Q))
        CLQ_Out(Q, item);
}
bool CLQ_IsEmpty(LinkQueue Q)
// 判断队列是否为空。
{
    // 请在Begin-End之间补充代码，完成队列是否为空的判断。
    /********** Begin *********/
    return Q.front->data == 0;

        /********** End **********/
}
int CLQ_Length(LinkQueue Q)
// 返回队列长度，rear指向尾结点。
{
    // 请在Begin-End之间补充代码，获取队列长度。
    /********** Begin *********/
    return Q.front->data;

    /********** End **********/
}
void CLQ_In(LinkQueue& Q, QElemType  x)
// 入队列, 新结点加入链表尾部。rear指向尾结点。
{
    // 请在Begin-End之间补充代码，完成新结点入队操作。
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
// 出队列。空队列时，返回值为false。rear指向尾结点。
{
    // 请在Begin-End之间补充代码，完成结点出队操作。
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
// rear指向尾结点。
// 获取队列头。空队列时返回值为false。
{
    if (CLQ_IsEmpty(Q))
    {
        return false;
    }
       

    item = Q.front->next->data;
    return true;
}
void CLQ_Print(LinkQueue& Q)
// 打印队列。
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

