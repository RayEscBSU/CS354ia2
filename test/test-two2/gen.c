#include <stdio.h>
int main() {
  double x;
  {
    x = 1 + 2;
    printf("%g\n", (double)(1 + 2));
    ;
  }
  {
    x = 10.0 + 2.0;
    printf("%g\n", (double)(10.0 + 2.0));
    ;
  }
  return 0;
}
