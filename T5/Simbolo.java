/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasonParser;

import java.util.Stack;

public class Simbolo
{
    String id;
    int nivel, endereco, nbytes, npar, inf, sup;
    public enum categorias{
        VAR, PROCEDURE, PARAMETER, REGISTER, FUNCTION, NONE;
    };
        categorias categoria;
    String tipo;
    
    public enum classes{
            VALOR, REFERENCIA;
    };
    classes classe;

    int valorInt;
    float valorReal;
    String valorString;

    public Simbolo(String id, int nivel, categorias categoria){
        this.id = id;
        this.nivel = nivel;
        this.categoria=categoria;
    }

    public Simbolo(){}

    public void setNivel(int nivel){this.nivel = nivel;}
    public void setClass(classes classe){this.classe = classe;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setCat(categorias cat){this.categoria=cat;}
    public void setEnd(int endereco){System.out.println("SETIPO");this.endereco=endereco;}
    public void setNbyte(int nbyte){this.nbytes=nbyte;}
    public void setNpar(int npar){this.npar=npar;}
    public void setInf(int inf){this.inf=inf;}
    public void setSup(int sup){this.sup=sup;}
    public void setId(String id){this.id=id;}
    public void setValue(int valor){this.valorInt=valor;this.tipo="INTEGER";}
    public void setValue(float valor){this.valorReal=valor;this.tipo = "REAL";}
    public void setValue(String valor){this.valorString=valor;this.tipo = "STRING";}

    public int getNivel(){return this.nivel;}
    public classes getClasse(){return this.classe;}
    public String getTipo(){return this.tipo;}
    public categorias getCat(){return this.categoria;}
    public int getEnd(){return this.endereco;}
    public int getNbytes(){return this.nbytes;}
    public int getNpar(){return this.npar;}
    public int getInf(){return this.inf;}
    public int getSup(){return this.sup;}
    public String getId(){return this.id;}
    public void printAll(){
        System.out.print(id + " ");
        System.out.print(nivel + " ");
        System.out.print(endereco + " ");
        System.out.print(nbytes + " ");
        System.out.print(npar + " ");
        System.out.print(inf + " ");
        System.out.print(sup + " ");
        System.out.print(categoria + " ");
        System.out.print(tipo + " ");
        System.out.println(classe);

        return;
    }
    public <Type> Type getValue()
    {
        if(this.tipo == tipos.INTEGER) return (Type) new Integer(this.valorInt);
        else if (this.tipo == tipos.REAL) return (Type) new Float(this.valorReal);
        else return (Type) new String(this.valorString);
    }
    //Cria um novo simbolo vazio no topo da pilha
    public static void createNew(Stack<Simbolo> stack){
        Simbolo s = new Simbolo();
        stack.add(s);
    }
    //Dado uma ID (string s) e uma pilha, retorna o simbolo na pilha.
    public static Simbolo searchByID(String s, Stack stack)
    {
        Iterator<Simbolo> iter = stack.iterator();
        while(iter.hasNext())
        {
            if(iter.next().getId().compareTo(s)==0)
                return iter.next();
        }
            return null;
    }
}
