#include<bits/stdc++.h>
using namespace std;
struct Node
{
    int data;
    struct Node*left,*right;
};
Node *makenewNode(int data){
    Node *temp=new Node;
    temp->data=data;
    temp->left=temp->right=NULL;
    return temp;
}
void levelOrderTraversal(Node*root){
    if(root==NULL){
        return;
    }
    queue<Node*>qq;
    qq.push(root);
    while(!qq.empty()){
         Node*node=qq.front();
        cout<<node->data<<" ";
        qq.pop();
        if(node->left) qq.push(node->left);
        if(node->right)qq.push(node->right);
    }
    }

int main(){
    Node*root=makenewNode(11);
    root->left=makenewNode(12);
    root->right=makenewNode(10);
    root->left->left=makenewNode(17);
    root->right->right=makenewNode(100);
    levelOrderTraversal(root);
    return 0;
}