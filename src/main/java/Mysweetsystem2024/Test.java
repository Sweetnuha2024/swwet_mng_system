package Mysweetsystem2024;

import java.util.HashMap;
import java.util.Map;

public class Test {
	 private boolean adminLoggedIn = false;
	    private String currentSection = "";
	    private Map<String, String> reports = new HashMap<>();

	    public Test() {
	        // Initialize any necessary data or state
	        reports.put("Financial Report", "Total Profits: $10000\nDetailed Report: [Details here]");
	        reports.put("Best-Selling Products", "Store A: Product X - 500 units\nStore B: Product Y - 300 units");
	        reports.put("User Statistics", "Nablus: 200 users\nJenin: 150 users");
	    }

	    // Method to simulate admin login
	    public void loginAsAdmin() {
	        // Simulate admin login process
	        adminLoggedIn = true;
	        System.out.println("Admin logged in.");
	    }

	    // Method to navigate to a specific section
	    public void navigateToSection(String section) {
	        if (adminLoggedIn) {
	            currentSection = section;
	            System.out.println("Navigated to: " + section);
	        } else {
	            throw new IllegalStateException("Admin not logged in. Please log in first.");
	        }
	    }

	    // Method to request a financial report
	    public String requestFinancialReport() {
	        if ("Financial Reports".equals(currentSection)) {
	            return reports.get("Financial Report");
	        } else {
	            throw new IllegalStateException("Not in the Financial Reports section.");
	        }
	    }

	    // Method to request a best-selling products report
	    public String requestBestSellingProductsReport() {
	        if ("Store Reports".equals(currentSection)) {
	            return reports.get("Best-Selling Products");
	        } else {
	            throw new IllegalStateException("Not in the Store Reports section.");
	        }
	    }

	    // Method to request user statistics by city
	    public String requestUserStatisticsByCity() {
	        if ("User Statistics".equals(currentSection)) {
	            return reports.get("User Statistics");
	        } else {
	            throw new IllegalStateException("Not in the User Statistics section.");
	        }
	    }
	}
	
	
	

