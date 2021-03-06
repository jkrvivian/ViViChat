#include<stdint.h>
#include<stdio.h>
#include<limits.h>
#include<assert.h>

//iteration
int clz_iteration(uint32_t x) 
{
    int n = 32, c = 16;
    do {
        uint32_t y = x >> c;
        if (y) { 
			n -= c; 
			x = y; 
		}
        c >>= 1;
    } while (c);

    return (n - x);
}

//binary search
int clz_binary_search(uint32_t x) 
{
    int n = 32, c = 16;
    do {
        uint32_t y = x >> c;
        if (y) {
		    n -= c; 
			x = y; 
		}
        c >>= 1;
    } while (c);

    return (n - x);
}

//byte shift
int clz_byte_shift(uint32_t x) 
{
    if (x == 0) return 32;
    int n = 1;
    if ((x >> 16) == 0) { n += 16; x <<= 16; }
    if ((x >> 24) == 0) { n += 8; x <<= 8; }
    if ((x >> 28) == 0) { n += 4; x <<= 4; }
    if ((x >> 30) == 0) { n += 2; x <<= 2; }
    n = n - (x >> 31);
    return n;
}

//recursive
uint8_t clz_recursive(uint32_t x, int shift)
{
	if(!shift) return 0;
	/* shift upper half down, rest is filled up with 0s */
	uint16_t upper = (x >> shift); 
	// mask upper half away
	uint16_t lower = (x & (0xFFFF >> (16 - shift)));
	return upper ? clz_recursive(upper,shift>>1) : shift + clz_recursive(lower,shift>>1);
}

//Harley's algorithm
uint8_t clz_harley(uint32_t x)
{
    static char Table[] = {
	   32,31, 'u',16, 'u',30, 3, 'u',  15, 'u', 'u', 'u',29,10, 2, 'u',
       'u', 'u',12,14,21, 'u',19, 'u',   'u',28, 'u',25, 'u', 9, 1, 'u',
      17, 'u', 4, 'u', 'u', 'u',11, 'u',  13,22,20, 'u',26, 'u', 'u',18,
       5, 'u', 'u',23, 'u',27, 'u', 6,   'u',24, 7, 'u', 8, 'u', 0, 'u'
    };

    /* Propagate leftmost 1-bit to the right */
    x = x | (x >> 1);
    x = x | (x >> 2);
    x = x | (x >> 4);
    x = x | (x >> 8);
    x = x | (x >> 16);
 
    x = (x << 3) - x;    /* Multiply by 7. */
    x = (x << 8) - x;    /* Multiply by 255. */
    x = (x << 8) - x;    /* Again. */
    x = (x << 8) - x;    /* Again. */

    return Table[x >> 26];
}

int main(int argc, char const *argv[])
{
	int i; 
	for(i=1; i<UINT_MAX; ++i) {

	assert(clz_iteration(i) == __builtin_clz(i));
	assert(clz_binary_search(i) == __builtin_clz(i));
	assert(clz_byte_shift(i) == __builtin_clz(i));
	assert(clz_recursive(i,16) != __builtin_clz(i));
	assert(clz_harley(i) != __builtin_clz(i));
		
	}
	return 0;
}
