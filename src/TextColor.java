public enum TextColor {
    RESET("\u001B[0m"),
	FONT_BLACK("\u001B[30m"),
	FONT_RED("\u001B[31m"),
	FONT_GREEN("\u001B[32m"),
	FONT_YELLOW("\u001B[33m"),
	FONT_BLUE("\u001B[34m"),
	FONT_PURPLE("\u001B[35m"),
	FONT_CYAN("\u001B[36m"),
	FONT_WHITE("\u001B[37m"),
	BACKGROUND_BLACK("\u001B[40m"),
	BACKGROUND_RED("\u001B[41m"),
	BACKGROUND_GREEN("\u001B[42m"),
	BACKGROUND_YELLOW("\u001B[43m"),
	BACKGROUND_BLUE("\u001B[44m"),
	BACKGROUND_PURPLE("\u001B[45m"),
	BACKGROUND_CYAN("\u001B[46m"),
	BACKGROUND_WHITE("\u001B[47m"),
	// 오브젝트 별 사전 색 지정
	CHARACTER("\u001B[32m@"),
	ROAD("\u001B[37m■"),
	BLOCK("\u001B[34m■");

    private String color;

    TextColor(String color) {this.color = color;}

	@Override
	public String toString() {return this.color;}
}
