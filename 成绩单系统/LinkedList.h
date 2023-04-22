#ifndef _LINKEDLIST_H_
#define _LINKEDLIST_H_
class LinkedList {
public:
    //这是单链表节点的结构体
    struct Node {
        int data;
        Node* next;
        Node(int a = 0, Node* b = nullptr) :data(a), next(b) {}
    };
private:
    Node* head;//链表的头结点
    int size;  //保存数据的数量，这是一个冗余数据
public:
    //默认构造函数，构造一个逻辑为空的链表
    LinkedList();
    //拷贝构造函数，构造一个逻辑上与参数内容相同的链表
    LinkedList(const LinkedList& rhs);
    //原生数组构造函数，构造一个内容与给定数组相同的链表
    LinkedList(int const a[], int n);
    //填充构造函数，构造一个内容为n个value的链表
    LinkedList(int n, int value);
    //析构函数，一定要自行实现，否则有内存泄漏
    ~LinkedList();
    //无话可说
    int getSize()const { return size; }
    //增删查改
    void insert(int pos, int value);
    void remove(int pos);
    int at(int pos)const;
    void modify(int pos, int newValue);
    void disp()const;
private:
    //辅助函数，返回指定位置的节点的指针
    Node* advance(int pos)const;
};
#endif // _LINKEDLIST_H_