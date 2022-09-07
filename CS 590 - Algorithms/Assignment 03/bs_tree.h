#ifndef __BS_TREE_H__
#define __BS_TREE_H__

enum bs_tree_color
{
  BS_RED,
  BS_BLACK
};

struct bs_tree_node
{
  int key;
  int color;
  bs_tree_node *left;
  bs_tree_node *right;
  bs_tree_node *p;
};

struct bs_tree_i_info
{
  int i_case_1;
  int i_case_2;
  int i_case_3;
  int i_left_rotate;
  int i_right_rotate;
  int i_duplicate;

  void reset()
  {
    i_case_1 = i_case_2 = i_case_3 = i_duplicate =
        i_left_rotate = i_right_rotate = 0;
  }
};

class bs_tree
{
protected:
  bs_tree_node *T_nil;
  bs_tree_node *T_root;

public:
  bs_tree();
  ~bs_tree();

  void insert(int, bs_tree_i_info &);
  int convert(int *, int);
  int check_black_height()
  {
    return check_black_height(T_root);
  }

  void inorder_output()
  {
    inorder_output(T_root, 1);
  }
  void output()
  {
    output(T_root, 1);
  }

protected:
    void insert(bs_tree_node*, bs_tree_i_info&);
    void insert_fixup(bs_tree_node*&, bs_tree_i_info&);

    int check_black_height(bs_tree_node*);

    void remove_all(bs_tree_node*);

    void left_rotate(bs_tree_node*);
    void right_rotate(bs_tree_node*);

    void inorder_output(bs_tree_node*, int);
    void output(bs_tree_node*, int);
};

#endif
