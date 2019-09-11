public class FindCommand extends Command {

	private String input;

	public FindCommand(String input) throws DukeException {
		this.input = input;
		if (input.length() < 5) {
			throw new DukeException(Ui.EMPTY_INPUT);
		}
	}
	@Override
	public String execute(TaskList tasks, DukeWriteFile storage) {
		StringBuilder taskFound = new StringBuilder();
		String findTask = input.substring(5);
		taskFound.append(Ui.BORDER + "\nHere are the matching tasks in your list:\n");
		int taskNumber = 1;
		for (int i = 0; i < tasks.getTaskList().size(); i++) {
			if (tasks.getTask(i).toString().contains(findTask)) {
				taskFound.append(taskNumber + "." + tasks.getTask(i).toString() + "\n");
				taskNumber++;
			}
		}
		taskFound.append(Ui.BORDER);
		return taskFound.toString();
	}
}
