# VGC System - Virtual Gift Card Management System

A comprehensive Java-based Virtual Gift Card System that allows users to manage customer accounts, create gift cards, process transactions, and track rewards points.

## Features

### Account Management
- Create customer accounts with initial balance
- View all customer accounts with their balances
- Automatic customer ID generation

### Gift Card Operations
- **Create Gift Cards**: Issue new gift cards linked to customer accounts
- **Top-up Cards**: Add funds to existing gift cards from account balance
- **Purchase Transactions**: Make purchases using gift cards
- **Block/Unblock Cards**: Temporarily disable or re-enable cards
- **Close Cards**: Permanently close cards and transfer remaining balance back to account

### Card Types & Rewards
- **Three Card Types**: Silver, Gold, Platinum
- **Points System**: Earn 50 points for every ₹500 spent
- **Automatic Upgrades**: Cards upgrade based on accumulated points
  - Silver → Gold (200 points)
  - Gold → Platinum (200 additional points)

### Transaction Tracking
- Complete transaction history
- Transaction numbers for each purchase
- View all transactions across the system

## System Architecture

The system consists of several Java classes:

- **`VGCSystem`**: Main system controller managing all operations
- **`Account`**: Customer account management
- **`GiftCard`**: Gift card functionality and operations
- **`Transaction`**: Transaction record keeping
- **`Status`**: Card status enumeration (Active, Blocked, Closed)
- **`GiftCardType`**: Card type enumeration (Silver, Gold, Platinum)
- **`Main`**: Interactive console interface

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Basic understanding of Java programming

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/JerryDev210/zoho-l3-vgc-system.git
cd zoho-l3-vgc-system
```

### 2. Compile the Project
```bash
cd src
javac *.java
```

### 3. Run the Application
```bash
java Main
```

## Usage

When you start the application, it automatically creates 3 sample customer accounts, each with ₹6000 balance.

### Menu Options

1. **Create Card** - Issue a new gift card for a customer
2. **Purchase** - Make a purchase using a gift card
3. **Topup** - Add funds to a gift card from account balance
4. **Block/UnBlock card** - Toggle card status between Active and Blocked
5. **Close card** - Permanently close a card and refund balance
6. **View Accounts** - Display all customer accounts
7. **View Cards** - Display all gift cards with details
8. **View Transactions** - Show transaction history
9. **Create new Customer Account** - Add a new customer account
10. **Exit** - Close the application

### Example Workflow

1. **View existing accounts** (Option 6)
2. **Create a gift card** (Option 1)
   - Enter Customer ID: 1
   - Enter PIN: 1234
   - Enter Initial Amount: 1000
3. **Make a purchase** (Option 2)
   - Enter Card ID: 1
   - Enter PIN: 1234
   - Enter Amount: 600
4. **View updated card details** (Option 7)

## Code Structure

```
src/
├── Main.java          # Main application entry point
├── VGCSystem.java     # Core system functionality
├── Account.java       # Customer account management
├── GiftCard.java      # Gift card operations
├── Transaction.java   # Transaction records
├── Status.java        # Card status enumeration
└── GiftCardType.java  # Card type enumeration
```

## Key Features Explained

### Points and Upgrades
- Every ₹500 spent earns 50 reward points
- Points automatically upgrade card types:
  - 200 points: Silver → Gold
  - 400 points total: Gold → Platinum
- Points reset after each upgrade

### Card Security
- PIN-based authentication for all card operations
- Card status validation (Active/Blocked/Closed)
- Account balance verification for top-ups

### Transaction Management
- Unique transaction IDs for tracking
- Complete audit trail of all purchases
- Transaction history linked to individual cards

## Error Handling

The system includes comprehensive error handling for:
- Invalid card IDs
- Incorrect PINs
- Insufficient balances
- Closed or blocked cards
- Unknown account IDs

## Future Enhancements

Potential improvements could include:
- Database integration for persistent storage
- Web-based interface
- Multiple currency support
- Advanced reporting features
- Card expiration management
- Mobile app integration

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under standard terms.

## Contact

For questions or support, please contact the repository maintainer.