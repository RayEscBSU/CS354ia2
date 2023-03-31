#include <stdio.h>
int main() {
  double f, x, y, z;
  {
    x = 1 + 2;
    printf("%g\n", (double)(1 + 2));
    ;
  }
  {
    y = x + 3;
    printf("%g\n", (double)(x + 3));
    ;
  }
  {
    z = x + y + 3;
    printf("%g\n", (double)(x + y + 3));
    ;
  }
  {
    f = z + x + y;
    printf("%g\n", (double)(z + x + y));
    ;
  }
  return 0;
}
