#include <stddef.h>
#include <stdlib.h>

#include "hashmap.h"

static int hashFunction(int key);

static Entry *values[INITIAL_BUCKETS_NUMBER];

// return key if successful, -1 if not
int put(int key, int value) {
    int hashIndex = hashFunction(key);

    // walk the chain looking for the key; ends on NULL if the key is not present
    Entry *currentBucket = values[hashIndex];
    while (currentBucket != NULL && currentBucket->key != key) {
        currentBucket = currentBucket->next;
    }

    if (currentBucket != NULL) {
        currentBucket->value = value; // overwrite current value by the key
        return key;
    }

    // the key is new: insert a fresh entry at the front of the chain
    Entry *newEntry = malloc(sizeof(Entry));
    if (newEntry == NULL) {
        return -1;
    }
    newEntry->key = key;
    newEntry->value = value;
    newEntry->next = values[hashIndex];
    values[hashIndex] = newEntry;

    return key;
}

int get(int key) {
    int hashIndex = hashFunction(key);

    Entry *current = values[hashIndex];
    // moving forward until the end of chain or while we will not find the key
    while (current != NULL && current->key != key) {
        current = current->next;
    }

    // we found the key
    if (current != NULL) {
        return current->value;
    } else {
        return -1;
    }
}

// map key value range to array index range
static int hashFunction(int key) {
    return (unsigned) key % INITIAL_BUCKETS_NUMBER;
}