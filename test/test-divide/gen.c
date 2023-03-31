#include <stdio.h>
int main() {
  double x;
  {
    x = 2 / 2;
    printf("%g\n", (double)(2 / 2));
    ;
  }
  {
    x = 20.0 / 10.0;
    printf("%g\n", (double)(20.0 / 10.0));
    ;
  }
  {
    x = 20.0 / 20.0;
    printf("%g\n", (double)(20.0 / 20.0));
    ;
  }
  {
    x = 20.0 / (-20.0);
    printf("%g\n", (double)(20.0 / (-20.0)));
    ;
  }
  {
    x = 20.0 / -20.0;
    printf("%g\n", (double)(20.0 / -20.0));
    ;
  }
  return 0;
}
