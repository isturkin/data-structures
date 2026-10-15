#pragma once

#define INITIAL_BUCKETS_NUMBER 100

int put(int key, int value);
int get(int key);

typedef struct Entry {
    int key;
    int value;
    struct Entry *next;
} Entry;