package jason_si2.env;


import br.ufrgs.f180.math.Point;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

/**
 * Classe que implementa o modelo do campo de futebol de robos
 * @author Caio Nishibe
 * @author Luís Mendes
 */
public class FieldModel extends GridWorldModel {

    //constantes para o tamanho do grid
    public static final int GRID_WIDTH = 25;
    public static final int GRID_HEIGHT = 17;
    //constantes  para o tamanho real das celulas do grid
    public static final double CELL_WIDTH = 19.6;
    public static final double CELL_HEIGHT = 19.88;
    //constante para o objeto bola no grid
    public static final int BALL = 16;
 

    public FieldModel(int numberAgents) {
        //cria um grid com numberAgents agentes
        super(GRID_WIDTH, GRID_HEIGHT, numberAgents);

     
    }

   
    /**
     * Método estático que converte coodernadas do grid para coordenadas do tewnta
     * @param x Coordenada x do grid
     * @param y Coordenada y do grid
     * @return Retorna um <code>Point</code> com a posição do tewnta referente ao grid
     */
    public static Point toTewntaPosition(int x, int y) {
        Point tewntaPosition = null;

        double xNew = 30 + (x * FieldModel.CELL_WIDTH) + (FieldModel.CELL_WIDTH / 2);
        double yNew = 30 + (y * FieldModel.CELL_HEIGHT) + (FieldModel.CELL_HEIGHT / 2);

        tewntaPosition = new Point(xNew, yNew);

        return tewntaPosition;
    }

    /**
     * Método estático que converte coordenadas do tewnta para coordenadas do grid
     * @param p <code>Point</code> contendo as coordenadas do tewnta
     * @return Retorna um vetor contendo na posição 0 a coordenada x do grid e na posicao
     * 1 a coordenada y do grid
     */
    public static int[] toJasonPosition(Point p)
    {
        int jasonPosition[] = new int[2];

        double xNew = (p.getX() - 30)/FieldModel.CELL_WIDTH;
        double yNew = (p.getY() - 30)/FieldModel.CELL_HEIGHT;

        jasonPosition[0] = (int)xNew;
        jasonPosition[1] = (int)yNew;
        
        return jasonPosition;
    }
}
