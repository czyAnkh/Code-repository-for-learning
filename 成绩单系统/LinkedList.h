#ifndef _LINKEDLIST_H_
#define _LINKEDLIST_H_
class LinkedList {
public:
    //���ǵ�����ڵ�Ľṹ��
    struct Node {
        int data;
        Node* next;
        Node(int a = 0, Node* b = nullptr) :data(a), next(b) {}
    };
private:
    Node* head;//�����ͷ���
    int size;  //�������ݵ�����������һ����������
public:
    //Ĭ�Ϲ��캯��������һ���߼�Ϊ�յ�����
    LinkedList();
    //�������캯��������һ���߼��������������ͬ������
    LinkedList(const LinkedList& rhs);
    //ԭ�����鹹�캯��������һ�����������������ͬ������
    LinkedList(int const a[], int n);
    //��乹�캯��������һ������Ϊn��value������
    LinkedList(int n, int value);
    //����������һ��Ҫ����ʵ�֣��������ڴ�й©
    ~LinkedList();
    //�޻���˵
    int getSize()const { return size; }
    //��ɾ���
    void insert(int pos, int value);
    void remove(int pos);
    int at(int pos)const;
    void modify(int pos, int newValue);
    void disp()const;
private:
    //��������������ָ��λ�õĽڵ��ָ��
    Node* advance(int pos)const;
};
#endif // _LINKEDLIST_H_