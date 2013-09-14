package alpro2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class DesenhadorApp {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.println("Desenhador, (c) PUCRS/ALPRO II, 2013.");
		Desenhador desenho = new Desenhador();
		String comando =  null;
		Scanner terminal = new Scanner(System.in);
		do {
			try {
				System.out.print("> ");
				comando = terminal.nextLine();
				processarComando(desenho, comando, terminal);
			} catch (NumberFormatException e) {
				System.out.println("Ops, ocorreu um erro...");
				System.out
						.println("Verifique se o valor informado é um inteiro.");
			} catch (Exception e) {
				System.out.println("Ops, ocorreu um erro...");
				System.out.println(e.getMessage());
			}

		} while (!comando.equals("sair"));
		System.out.println("**FIM**");
	}

	private static void processarComando(Desenhador desenho,
			String comando, Scanner terminal) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.printf("[%s]\n", comando);
		String[] palavras = comando.split(" ");
		System.out.println(Arrays.toString(palavras));
		if (palavras[0].equals("criar")) {
			if (palavras[1].equals("quadrado")) {
				criarQuadrado(desenho, terminal);
			} else if (palavras[1].equals("círculo")) {
				criarCirculo(desenho, terminal);
			}
		} else if (palavras[0].equals("listar")) {
			listar(desenho);
		} else if (palavras[0].equals("gravar")) {
			gravar(desenho);
		} else if (palavras[0].equals("ler")) {
			desenho.setFiguras(ler());
		} else if (palavras[0].equals("consultar")) {
			if (palavras[1].equals("área")) {
				consultarArea(desenho, palavras);
			}
		}
	}

	private static void listar(Desenhador desenho) {
		System.out.println(desenho.listar());
	}

	private static void consultarArea(Desenhador desenho, String[] palavras) {
		int pos = Integer.parseInt(palavras[2]);
		Figura f = desenho.getFiguraAt(pos);
		if (f != null) {
			System.out.printf("%.3f", f.getArea());
		}
	}

	private static Desenhador ler() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		Desenhador desenho;
		FileInputStream fileStream = new FileInputStream(
				"desenhador.dat");
		ObjectInputStream objectStream = new ObjectInputStream(
				fileStream);
		desenho = (Desenhador) objectStream.readObject();
		objectStream.close();
		return desenho;
	}

	private static void gravar(Desenhador desenho)
			throws FileNotFoundException, IOException {
		FileOutputStream fileStream = new FileOutputStream(
				"desenhador.dat");
		ObjectOutputStream objectStream = new ObjectOutputStream(
				fileStream);
		objectStream.writeObject(desenho);
		objectStream.flush();
		objectStream.close();
	}

	private static void criarCirculo(Desenhador desenho, Scanner terminal) {
		System.out.print("\traio: ");
		String entrada = terminal.nextLine();
		int raio = Integer.parseInt(entrada);
		Circulo c = new Circulo(raio);
		desenho.guardar(c);
		System.out.println(c);
	}

	private static void criarQuadrado(Desenhador desenho, Scanner terminal) {
		System.out.print("\tlado: ");
		String entrada = terminal.nextLine();
		int lado = Integer.parseInt(entrada);
		Quadrado q = new Quadrado(lado);
		desenho.guardar(q);
		System.out.println(q);
	}
}
