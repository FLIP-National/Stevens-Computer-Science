#include <cstdio>
#include <cstdlib>

#include "sort.h"

/*
 * HW 2 part
 */
int string_compare(char *s1, char *s2)
{
  /*
   * We assume that s1 and s2 are non-null pointers
   */
  int i;

  i = 0;
  while ((s1[i] != 0) && (s2[i] != 0) && (s1[i] == s2[i]))
    i++;

  if (s1[i] == s2[i])
    return 0;
  else
  {
    if (s1[i] < s2[i])
      return -1;
    else
      return 1;
  }
} /*>>>*/

void counting_sort_digit(char **A, int *A_len, char **B, int *B_len, int n, int d)
{
  int* t = new int[256];
  for (int i=0; i<=255; i++)
  {
    t[i] = 0;
  }
  for (int x=0; x<=n; x++)
  {
    if (A_len[x] - 1<d)
    {
      t[0] = t[0] + 1;
    }
    else
    {
      t[A[x][d]] = t[A[x][d]] + 1;
    }
  }
  for (int x=1; x<=254; x++)
  {
    t[x] = t[x] - t[x - 1];
  }
  for (int y = n-1; y>=0; y--)
  {
    if (A_len[y] - 1<d)
    {
      B_len[t[0] - 1] = A_len[y];
      B[t[0] - 1] = A[y];
      t[0] = t[0] - 1;
    }
    else
    {
      B_len[t[A[y][d]] - 1] = A_len[y];
      B[t[A[y][d]] - 1] = A[y];
      t[A[y][d]] = t[A[y][d]] - 1;
    }
  }
  delete[] t;
  for (int z = 0; z <= n - 1; z++)
  {
    A_len[z] = B_len[z];
    A[z] = B[z];
  }
}

/*
 * radix sort
 */
void radix_sort_cs(char **A, int *A_len, int n, int m)
{
  char **newA;
  char **newB;
  int *newA_len;
  int *newB_len;
  char **B;
  int *B_len;
  B = new char *[n];
  B_len = new int[n];
  newA = A;
  newB = B;
  newA_len = A_len;
  newB_len = B_len;
  for (int z = m - 1; z >= 0; z--)
  {
    counting_sort_digit(newA, newA_len, newB, newB_len, n - 1, z);
  }
}

/*
 * Simple function to check that our sorting algorithm did work
 * -> problem, if we find position, where the (i-1)-th element is
 *    greater than the i-th element.
 */
bool check_sorted(char **A, int l, int r)
{
  for (int i = l + 1; i < r; i++)
    if (string_compare(A[i - 1], A[i]) > 0)
      return false;
  return true;
}
