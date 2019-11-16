# Secure Filestore

## Project Summary

The goal is to create a project that involves file encryption and storing keys in a hash table for fast file location in large file directories as well as storing the byte array in a hashmap for fast encryption and decryption of large files. Additional measures for this secure filestore project may include creating a java app for adding and removing files from the encrypted store and implementing some form of two factor authentication.

The basic filem encryption will include the following steps:
* Take an input to call the decrypt or encrypt method.
* Take a file path input.
* Create a key using AES algorithm.
* Create an instance of the crypto cipher class using the AES transformatiion.
* Create a stream take takes the file path as a parameter
* Create a byte array or hash table of the input file
* Encrypt or decrypt the file
* Return an outfile file.
* Create a file path location in a hash map containing all file paths in the filestore.
