/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

class pair implements Comparable<pair>
    {

    public int number;
    public double prob;

    @Override
    public int compareTo(pair o)
        {
        if (this.prob < o.prob)
            {
            return 1;
            }
        else if (this.prob > o.prob)
            {
            return -1;
            }
        else
            {
            return 0;
            }

        }

    pair(int x, double y)
        {
        number = x;
        prob = y;
        }

    }

public class Vache
    {

    static double[][] prob = new double[10][5];
    static ArrayList<pair> InitialList = new ArrayList<>();

    static boolean verify(int number, int essai, int vache, int toreau)
        {
        return ((toreau * 10 + vache) == verify(number, essai));
        }

    static int verify(int number, int essai)
        {
        int mtoreau = 0, mvache = 0, a = number / 1000, b = (number / 100) % 10, c = (number / 10) % 10, d = number % 10, e = essai / 1000, f = (essai / 100) % 10, g = (essai / 10) % 10, h = essai % 10;
        if (a == e)
            {
            mtoreau++;
            }
        if (b == f)
            {
            mtoreau++;
            }
        if (c == g)
            {
            mtoreau++;
            }
        if (d == h)
            {
            mtoreau++;
            }
        if ((a == f) || (a == g) || (a == h))
            {
            mvache++;
            }
        if ((b == e) || (b == g) || (b == h))
            {
            mvache++;
            }
        if ((c == f) || (c == e) || (c == h))
            {
            mvache++;
            }
        if ((d == f) || (d == g) || (d == e))
            {
            mvache++;
            }
        return (mtoreau * 10 + mvache);
        }

    static boolean Existin(int x, int i)
        {
        int a = i / 1000;
        int b = (i / 100) % 10;
        int c = (i / 10) % 10;
        int d = i % 10;
        return !((x != c) && (x != b) && (x != a) && (x != d));
        }

    static boolean Existinn(int x, int deg, int i)
        {
        int a = i / 1000;
        int b = (i / 100) % 10;
        int c = (i / 10) % 10;
        int d = i % 10;
        if ((deg == 1) && (a == x))
            {
            return true;
            }
        if ((deg == 2) && (b == x))
            {
            return true;
            }
        if ((deg == 3) && (c == x))
            {
            return true;
            }
        return (deg == 4) && (d == x);

        }

    static boolean can(int i)
        {
        int a = i / 1000;
        int b = (i / 100) % 10;
        int c = (i / 10) % 10;
        int d = i % 10;
        return (d != c) && (d != b) && (d != a) && (c != b) && (c != a) && (b != a);
        }

    static void exclude(int a)
        {
        int i = 0;
        while (i < (InitialList.size()))
            {
            if (Existin(a, InitialList.get(i).number))

                {
                InitialList.remove(i);
                }

            else
                {
                i++;
                }
            }
        }

    static void include(int a)
        {
        int i = 0;
        while (i < (InitialList.size()))
            {
            if (!Existin(a, InitialList.get(i).number))

                {
                InitialList.remove(i);
                }

            else
                {
                i++;
                }
            }
        }

    static void Toreau(int a, int deg)
        {
        int i = 0;
        while (i < (InitialList.size()))
            {
            if (!Existinn(a, deg, InitialList.get(i).number))

                {
                InitialList.remove(i);
                }

            else
                {
                i++;
                }
            }
        }

    static void GenerateInitialList()
        {
        InitialList.clear();
        for (int i = 1023; i <= 9876; i++)
            {
            if (can(i))
                {
                InitialList.add(new pair(i, 0));
                }
            }

        }

    static void initialProb()
        {
        for (int j = 0; j < 10; j++)
            {
            for (int k = 0; k < 5; k++)
                {
                prob[j][k] = 0;
                }
            }
        }

    static void showProb()
        {
        for (int j = 0; j < 10; j++)
            {
            System.out.format(" %d: %.2f%n", j, prob[j][0]);
            for (int k = 1; k < 5; k++)
                {
                System.out.format(" %.2f", prob[j][k]);
                }
            System.out.println();
            }
        }

    static void calcProb()
        {
        int a, b, c, d;
        initialProb();
        int i = 0;
        while (i < (InitialList.size()))
            {
            a = InitialList.get(i).number / 1000;
            b = (InitialList.get(i).number / 100) % 10;
            c = (InitialList.get(i).number / 10) % 10;
            d = InitialList.get(i).number % 10;
            prob[a][0] += 1;
            prob[a][1] += 1;
            prob[b][0] += 1;
            prob[b][2] += 1;
            prob[c][0] += 1;
            prob[c][3] += 1;
            prob[d][0] += 1;
            prob[d][4] += 1;
            i++;
            }

        for (int j = 0; j < 10; j++)
            {
            for (int k = 1; k < 5; k++)
                {
                if (prob[j][0] > 0)
                    {
                    prob[j][k] = (prob[j][k] / prob[j][0]) * 100;
                    }
                }

            prob[j][0] = (prob[j][0] / (InitialList.size() * 4)) * 100;

            }
        i = 0;
        while (i < InitialList.size())
            {
            a = InitialList.get(i).number / 1000;
            b = (InitialList.get(i).number / 100) % 10;
            c = (InitialList.get(i).number / 10) % 10;
            d = InitialList.get(i).number % 10;
            InitialList.get(i).prob = (prob[a][0] * prob[a][1] + prob[b][0] * prob[a][2] + prob[c][0] * prob[a][3] + prob[d][0] * prob[a][4]) / 100;
            i++;
            }

        }

    static void essai(int essai, int vache, int toreau)
        {
        int i = 0;
        while (i < (InitialList.size()))
            {
            if (!verify(InitialList.get(i).number, essai, vache, toreau))

                {
                InitialList.remove(i);
                }

            else
                {
                i++;
                }
            }

        }

    static int mostprobnumber()
        {
        int i = 0;
        Random rn = new Random();
        Collections.sort(InitialList, (pair o1, pair o2) -> o1.compareTo(o2));
        while (i < InitialList.size() - 1)
            {
            if (InitialList.get(i).prob != InitialList.get(i + 1).prob)
                {
                break;
                }
            i++;
            }
        if (i == 0)
            {
            return InitialList.get(0).number;
            }

        return InitialList.get(rn.nextInt(i)).number;
        }

    static int worstprobnumber()
        {
        int i = 0;
        Random rn = new Random();
        Collections.sort(InitialList, (pair o1, pair o2) -> o1.compareTo(o2));
        Collections.reverse(InitialList);
        while (i < InitialList.size() - 1)
            {
            if (InitialList.get(i).prob != InitialList.get(i + 1).prob)
                {
                break;
                }
            i++;
            }
        if (i == 0)
            {
            return InitialList.get(0).number;
            }

        return InitialList.get(rn.nextInt(i)).number;
        }


    static int play(int number)
        {
        int next = 0, retour = 0, compteur = 0;
        GenerateInitialList();
        while (InitialList.size() != 1)
            {
            compteur++;
            calcProb();
            if (compteur == 2)  next = worstprobnumber();
            else  next = mostprobnumber();
            retour = verify(number, next);
            essai(next, retour % 10, retour / 10);
            }
        return compteur;
        }

    static void interactivegame()
        {
        Scanner scanner = new Scanner(System.in);
        int choix = 1;
        int i = 0;
        int number = 0, vache = 0, taureau = 0;

        while (choix != 0)
            {
            System.out.println("il existe " + InitialList.size() + " possibilité\n1/initiate List\n2/enter data\n3/show probabilité\n4/show most prob number\n5/show possibilités\n0/exit");
            choix = (scanner.nextInt());
            switch (choix)
                {
                case 1:
                    GenerateInitialList();
                    break;
                case 2:
                    System.out.println("entrez le numero");
                    number = (scanner.nextInt());
                    System.out.println("entrez le nombre de vache");
                    vache = (scanner.nextInt());
                    System.out.println("entrez le nombre de taureau");
                    taureau = (scanner.nextInt());
                    essai(number, vache, taureau);
                    break;
                case 3:
                    calcProb();
                    showProb();
                    break;
                case 4:
                    calcProb();
                    System.out.println("le nombre le plus probable est " + mostprobnumber());
                    break;
                case 5:
                    calcProb();
                    mostprobnumber();
                    i = 0;
                    while (i < InitialList.size())
                        {
                        System.out.println(InitialList.get(i).number + " " + InitialList.get(i).prob);
                        i++;
                        }
                case 6:
                    calcProb();
                    System.out.println("le nombre le plus probable est " + worstprobnumber());
                    break;
                }
            if (InitialList.size() == 1)
                {
                System.out.println("Bravo " + InitialList.get(0).number);
                }

            }

        }

    public static void main(String[] args)
        {
        int i = 0;
        interactivegame();

        double somme = 0;
        ArrayList<Integer> List = new ArrayList<Integer>();
        for (i = 1023; i <= 9876; i++)
            {
            if (can(i))
                {
                List.add(i);

                }
            }
        i = 0;
        while (i < List.size())
            {
            somme += play(List.get(i));
            i++;
            }
        System.out.print("moyenne" + somme / List.size());
        }

    }
