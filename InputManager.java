import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class InputManager {

    private static Scanner in = new Scanner(System.in);

    public InputManager() {
    }

    //DOB Address Phone #, savings account
    public String newUser() {
        System.out.println("Please enter the minimum information required for a new user:");
        System.out.println("First Name?");
        String firstName = in.nextLine();
        System.out.println("Last Name");
        String lastName = in.nextLine();
        System.out.println("Phone Number?");
        String phoneNumber = in.nextLine();
        System.out.println("Email?");
        String email = in.nextLine();
        System.out.println("Savings Account initial deposit amount?");
        double savingsDeposit = Double.parseDouble(in.nextLine());

//        check_yes_no("Would you like to create a checking account?");
//        check_yes_no("Would you like to create a savings account?");


        return "";
    }

    /**
     * @return user type input
     * <p>
     * Checks to make sure user input matches the user type options
     * Will continue to prompt user to reenter input until it's accepted
     */
    public String checkUserTypeInput() {
        String options = "Options: ";
        int endIndexUserTypeList = RunBank.UserType.values().length - 1;
        for (RunBank.UserType type : RunBank.UserType.values()) {
            options += type;
            if (type.ordinal() != endIndexUserTypeList) {
                options += ", ";
            }
        }
        RunBank.UserType userType = null;
        while (true) {
            System.out.println("Which account would you like to use?");
            System.out.println(options);
            try {
                String input = in.nextLine();
                userType = RunBank.UserType.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return userType.name();
    }

    /**
     * @return transaction type input
     * <p>
     * Checks to make sure user input matches the transaction type options
     * Will continue to prompt user to reenter input until it's accepted
     */
    public String checkTransactionTypeInput() {
        RunBank.TransactionType transactionTypeEnum = null;

        String options = "Options: ";
        options += RunBank.TransactionType.values()[0];
        boolean isFirst = true;
        for (RunBank.TransactionType type : RunBank.TransactionType.values()) {
            if (isFirst) {
                isFirst = false;
                continue;
            }
            options += ", " + type;
        }
        while (true) {
            System.out.println("What transaction type would you like to execute?");
            System.out.println(options);
            try {
                String inputTransaction = in.nextLine();
                transactionTypeEnum = RunBank.TransactionType.valueOf(inputTransaction.toUpperCase());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Input is not a valid transaction type.");
                System.out.println();
                continue;
            }
        }
        return transactionTypeEnum.name();
    }

    public boolean checkFileTransactionTypeInput(String fileInput) {
        RunBank.FileTransaction transactionTypeEnum = null;
        try {
            transactionTypeEnum = RunBank.FileTransaction.valueOf(fileInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }


    /**
     * @return account type input
     * <p>
     * Checks to make sure user input matches the account type options
     * Will continue to prompt user to reenter input until it's accepted
     */
    public String checkAccountTypeInput() {
        String options = "Options: ";
        int endIndexAccountTypeList = RunBank.AccountType.values().length - 1;
        for (RunBank.AccountType type : RunBank.AccountType.values()) {
            options += type;
            if (type.ordinal() != endIndexAccountTypeList) {
                options += ", ";
            }
        }

        RunBank.AccountType accountType = null;
        while (true) {
            System.out.println(options);
            try {
                String input = in.nextLine();
                accountType = RunBank.AccountType.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return accountType.name();
    }

    public boolean checkAccountTypeInput(String fileInput) {
        RunBank.AccountType accountType = null;
        try {
            accountType = RunBank.AccountType.valueOf(fileInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("This is NOT a valid account type.");
            return false;
        }
        return true;
    }


    /**
     * @return user Yes or No input
     * <p>
     * Checks to make sure user input matches the yes or no type options
     * Will continue to prompt user to reenter input until it's accepted
     */
    //Checks user input until user selects yes or no
    public String check_yes_no(String text_input) {
        RunBank.YesNo yesNo = null;

        while (true) {
            System.out.println(text_input);
            System.out.println("Yes or No?");
            try {
                String input = in.nextLine();
                yesNo = RunBank.YesNo.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return yesNo.name();
    }

    /**
     * @return user a or b option
     * Checks to make sure user input matches the A or B type options
     * Will continue to prompt user to reenter input until it's accepted
     */
    //compares enum AB to user input
    public String checkABInput() {
        RunBank.AB option = null;
        while (true) {
            System.out.println("A,B, or C?");
            try {
                String input = in.nextLine();
                option = RunBank.AB.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("This is NOT a valid response.");
                continue;
            }
        }
        return option.name();
    }


    /**
     * @return user money input
     * <p>
     * Checks to make sure user input is an acceptable numerical value
     * Will continue to prompt user to reenter input until it's accepted
     * Does not accept negative values
     */
    public double checkMoneyInput(String transType) {
        String message = "How much money would you like to " + transType + "?";
        double inputAmount = 0;
        while (true) {
            try {
                System.out.println(message);
                inputAmount = Double.parseDouble(in.nextLine());
                if (inputAmount < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: not a valid amount.");
            }
        }
        return inputAmount;
    }

    public String checkDateOfBirthInput() throws ParseException {
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        String inputDobPattern = "MM/dd/yy";
        SimpleDateFormat inDateFormat = new SimpleDateFormat("MM/dd/yy");

        String outputDobPattern = "MMMMM dd, yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(outputDobPattern);

        while(true) {
            System.out.println("What is your Date of Birth?");
            System.out.println(inputDobPattern);
            String dobString = in.nextLine();
            if(dobString.matches(regex)) {
                Date date = simpleDateFormat.parse(dobString);
                return inDateFormat.format(date);
            }
            System.out.println("Invalid Date of Birth. Please try again..");
        }
    }

    public String checkPhoneNumberInput() {
        String phoneNumber = "";
        while(true) {
            System.out.println("Phone Number?");
            System.out.println("3-digit area code: ");
            String area = in.nextLine();
            System.out.println("7 digit phone number: ");
            String number = in.nextLine();
            if (area == null || number == null) {
                System.out.println("Not a valid phone number...");
                continue;
            }
            try {
                int intArea = Integer.parseInt(area);
                int intNumber = Integer.parseInt(number);
                String combinedNumber = area+number;
                if(combinedNumber.length() != 10)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Not a valid phone number...");
                continue;
            }
            phoneNumber = "(" + area + ") " + number.substring(0,3) + "-" + number.substring(3,7);
            break;
        }
        return phoneNumber;
    }

    public String checkEmailAddressInput() {
        //regex that looks for @ and ensures that there is a decimal extension at the end
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        while (true) {
            System.out.println("What is your email?");
            String email = in.nextLine();
            if (email.matches(regex))
                return email;
            System.out.println("Invalid email. Please try again");
        }
    }

    public void checkPassword(String correctPassword)  {
        while (true) {
            try {
                System.out.println("Please enter your password; ");
                String inPassword = in.nextLine();
                if(!inPassword.equals(correctPassword))
                    throw new IncorrectPasswordException(inPassword);
                break;
            } catch (IncorrectPasswordException e) {
                System.out.println(e);
                System.out.println("Please try again: ");
            }
        }
    }
}

