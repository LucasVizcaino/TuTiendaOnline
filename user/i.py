import os
import binascii

key = binascii.hexlify(os.urandom(64)).decode()
print(key)import os
import binascii

key = binascii.hexlify(os.urandom(64)).decode()
print(key)
