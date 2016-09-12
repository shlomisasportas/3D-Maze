package controller;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;

public class CommandsManager {
	
	private Model model;
	private View view;
		
	public CommandsManager(Model model, View view) {
		this.model = model;
		this.view = view;		
	}
	
	public HashMap<String, Command> getCommandsMap() {
		HashMap<String, Command> commands = new HashMap<String, Command>();
		commands.put("dir", new DisplayDirCommand());
		commands.put("generate_maze", new GenerateMazeCommand());
		commands.put("display", new DisplayMazeCommand());
		commands.put("display_cross_section", new DisplayCrossSectionBy());
		commands.put("save_compressed_maze", new SaveCompressedMaze());
		commands.put("load_compressed_maze", new LoadCompressedMaze());
		commands.put("solve", new SolveMaze());
		commands.put("display_solution", new DisplaySolution());
		commands.put("exit", new Exit());
		
		return commands;
	}
	public class Exit implements Command {
		
		@Override
		public void doCommand(String[] args) {

		}
	}
	public class DisplaySolution implements Command {
		
		@Override
		public void doCommand(String[] args) {
			String name = args[0];
		}
	}
	public class SolveMaze implements Command {
		
		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			String algorithm = args[1];
		}
	}
	public class LoadCompressedMaze implements Command {
		
		@Override
		public void doCommand(String[] args) {
			String fileName = args[0];
			String name = args[1];
		}
	}
	public class SaveCompressedMaze implements Command {
		
		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			String fileName = args[1];
		}
	}
	public class DisplayCrossSectionBy implements Command {	
			@Override
			public void doCommand(String[] args) {
				String name = args[0];
				String axis = args[1];
				String mazeName = args[2];
			}
		}
	public class DisplayDirCommand implements Command {
		
		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			String path = args[1];
			view.displayPath(name,path);
		}
	}
	public class GenerateMazeCommand implements Command {
		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			int levels = Integer.parseInt(args[1]);
			int rows = Integer.parseInt(args[2]);
			int cols = Integer.parseInt(args[3]);
			model.generateMaze(name, levels, rows, cols);
		}		
	}
	public class DisplayMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			Maze3d maze = model.getMaze(name);
			view.displayMaze(maze);
		}
		
	}
	
	
}
