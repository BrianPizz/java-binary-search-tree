# Binary Search Tree (BST) Console Application in Java

## 📘 Overview

This Java application allows users to interact with a **Binary Search Tree (BST)** through a command-line interface. The program supports standard BST operations such as creating a tree, inserting and deleting nodes, and displaying the tree using in-order, pre-order, and post-order traversals.

This assignment was developed as part of **Computer Science 201 - Lesson 1, Chapter 16**, and is intended to demonstrate a clear understanding of tree structures and recursive algorithms using the Java programming language.

---

## 🎯 Features

- ✅ **Create Balanced Tree**  
  Initializes a balanced binary search tree with the values 1 to 7.
  
- ➕ **Insert Node**  
  Prompts user input to insert a new node while maintaining BST rules.
  
- ❌ **Delete Node**  
  Prompts user input to delete a node. Handles:
  - Leaf nodes
  - Nodes with one child
  - Nodes with two children (in-order successor is used)
  
- 🌿 **Traversals**
  - **InOrder (LNR)**: Prints nodes in ascending order.
  - **PreOrder (NLR)**: Prints nodes in root-left-right order.
  - **PostOrder (LRN)**: Prints nodes in left-right-root order.

- 🔁 **Interactive Menu**  
  Loops until the user chooses to exit the program.

---

## 💡 How It Works

### 🌱 Node Structure
Each node contains:
- An integer value (`data`)
- A left child
- A right child

### 🌲 Tree Construction
The default tree (option 1) is manually created as a balanced BST:
![bst](https://github.com/user-attachments/assets/e902388c-d3e8-4c6c-a59d-77675ea037f6)
