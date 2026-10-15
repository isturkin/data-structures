CC = cc
CFLAGS = -Wall -Wextra -std=c11

# hashmap.c has no main() yet, so we can only compile it to an object file
all: hashmap.o

hashmap.o: hashmap.c hashmap.h
	$(CC) $(CFLAGS) -c hashmap.c -o $@

clean:
	rm -f hashmap.o

.PHONY: all clean
