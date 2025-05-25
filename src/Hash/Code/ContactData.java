package Hash.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
	private static final String phoneData = """
			Charles Brown,333344455555
			Charles Brown,333344455555
			Charles Brown,333344455555
			Alice Johnson,123456789012
			Bob Smith,987654321098
			Carol White,456789012345
			David Lee,234567890123
			Eva Green,345678901234
			Frank Harris,567890123456
			Grace Moore,678901234567
			Henry Clark,789012345678
			Irene Lewis,890123456789
			Jack Wilson,901234567890
			""";

	private static final String emailData = """
			Charles Brown,charles.brown@example.com
			Alice Johnson,alice.johnson@example.com
			Bob Smith,bob.smith@example.com
			Carol White,carol.white@example.com
			David Lee,david.lee@example.com
			Eva Green,eva.green@example.com
			Frank Harris,frank.harris@example.com
			Charles Brown,charles.brown@example.com
			Charles Brown,charles.brown@example.com
			Grace Moore,grace.moore@example.com
			Henry Clark,henry.clark@example.com
			Irene Lewis,irene.lewis@example.com
			Jack Wilson,jack.wilson@example.com
			""";

	public static List<Contact> getData(String type) {

		List<Contact> dataList = new ArrayList<>();

		Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);

		while (scanner.hasNext()) {

			String[] data = scanner.nextLine().split(",");

			Arrays.asList(data).replaceAll(String::trim);

			if (type.equals("phone")) {
				dataList.add(new Contact(data[0], Long.parseLong(data[1])));

			} else if (type.equals("email")) {
				dataList.add(new Contact(data[0], data[1]));
			}

		}

		return dataList;

	}
}
