#include <stdio.h>
int main() {
  double x;
  x = 1 * 2;
  printf("%g\n", (double)(1 * 2));
  x = 2.0 * 2.0;
  printf("%g\n", (double)(2.0 * 2.0));
  x = 2.0 * 2.0 * 1;
  printf("%g\n", (double)(2.0 * 2.0 * 1));
  x = 10 * -10;
  printf("%g\n", (double)(10 * -10));
  x = 10 * --10;
  printf("%g\n", (double)(10 * --10));
  return 0;
}
